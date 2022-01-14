package ru.bellintegrator.practice.organizatrion.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import ru.bellintegrator.practice.PracticeApplication;
import ru.bellintegrator.practice.organizatrion.dto.OrganizationRequestDto;
import ru.bellintegrator.practice.organizatrion.dto.OrganizationResponseDto;
import ru.bellintegrator.practice.organizatrion.dto.OrganizationSaveDto;
import ru.bellintegrator.practice.organizatrion.dto.OrganizationUpdateDto;
import ru.bellintegrator.practice.organizatrion.model.Organization;
import ru.bellintegrator.practice.organizatrion.service.OrganizationService;
import java.util.ArrayList;
import java.util.List;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = PracticeApplication.class)
@TestPropertySource(locations = "/application-test.properties")
@Sql(scripts = {"/test-schema.sql", "/test-data.sql"})
@AutoConfigureMockMvc
class OrganizationControllerTest {
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private OrganizationService organizationService;
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void filterShouldReturnSuccess() throws Exception {
        OrganizationRequestDto organizationRequestDto = new OrganizationRequestDto("Polo", "111", true);
        List<OrganizationResponseDto> list = organizationService.filter(organizationRequestDto);
        mockMvc.perform(post("/api/organization/list")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(organizationRequestDto))
                ).andExpect(status().isOk())
                .andExpect(jsonPath("$.data[0].id", is(list.get(0).getId())))
                .andExpect(jsonPath("$.data[0].name", is(list.get(0).getName())))
                .andExpect(jsonPath("$.data[0].isActive", is(list.get(0).asActive())))
                .andExpect(jsonPath("$.data[1].id", is(list.get(1).getId())))
                .andExpect(jsonPath("$.data[1].name", is(list.get(1).getName())))
                .andExpect(jsonPath("$.data[1].isActive", is(list.get(1).asActive())));
    }

    @Test
    public void filterShouldReturnErrorWhenRequestIsIncorrect() throws Exception {
        OrganizationRequestDto organizationRequestDto = new OrganizationRequestDto("qasdad", "111", true);
        mockMvc.perform(post("/api/organization/list")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(organizationRequestDto)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data", is(new ArrayList())));
    }

    @Test
    public void loadByIdShouldReturnSuccess() throws Exception {
        OrganizationUpdateDto organizationUpdateDto = organizationService.loadById(1);
        Organization organization = OrganizationUpdateDto.getOrganizationFromUpdateDto(organizationUpdateDto);
        mockMvc.perform(
                        get("/api/organization/1")
                                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data.name", is(organization.getName())))
                .andExpect(jsonPath("$.data.fullName", is(organization.getFullName())))
                .andExpect(jsonPath("$.data.inn", is(organization.getInn())))
                .andExpect(jsonPath("$.data.kpp", is(organization.getKpp())))
                .andExpect(jsonPath("$.data.address", is(organization.getAddress())))
                .andExpect(jsonPath("$.data.phone", is(organization.getPhone())))
                .andExpect(jsonPath("$.data.isActive", is(organization.asActive())));
    }

    @Test
    public void shouldReturnErrorWhenGetNotExistedOrganization() throws Exception {
        mockMvc.perform(
                        get("/api/organization/5"))
                .andExpect(status().is5xxServerError())
                .andExpect(mvcResult -> mvcResult.getResolvedException()
                        .getClass().equals(NullPointerException.class));
    }

    @Test
    void saveShouldReturnSuccess() throws Exception{
        OrganizationSaveDto organizationSaveDto = new OrganizationSaveDto("ar f","qwqw",
                "111","222","Msk","84950000000",true);
        mockMvc.perform(post("/api/organization/save")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(organizationSaveDto)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data.result", is("success")));
    }

    @Test
    void saveShouldReturnError() throws Exception{
        OrganizationSaveDto organizationSaveDto = new OrganizationSaveDto("ar f");
        mockMvc.perform(post("/api/organization/save")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(organizationSaveDto)))
                .andExpect(status().is5xxServerError());
    }

    @Test
    void updateShouldReturnSuccess() throws Exception{
        OrganizationUpdateDto organizationUpdateDto = new OrganizationUpdateDto(1,"qqq","QQQ",
                "121","223","Msk","89099999999",true);
        mockMvc.perform(post("/api/organization/update")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(organizationUpdateDto)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data.result", is("success")));
    }

    @Test
    void updateShouldReturnError() throws Exception{
        OrganizationUpdateDto organizationUpdateDto = new OrganizationUpdateDto(100,"qqq","QQQ",
                "121","223","Msk","89099999999",true);
        mockMvc.perform(post("/api/organization/update")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(organizationUpdateDto)))
                .andExpect(status().is5xxServerError());
    }
}