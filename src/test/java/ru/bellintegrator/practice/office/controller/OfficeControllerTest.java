package ru.bellintegrator.practice.office.controller;

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
import ru.bellintegrator.practice.office.dto.OfficeRequestDto;
import ru.bellintegrator.practice.office.dto.OfficeResponseDto;
import ru.bellintegrator.practice.office.dto.OfficeSaveDto;
import ru.bellintegrator.practice.office.dto.OfficeUpdateDto;
import ru.bellintegrator.practice.office.service.OfficeService;
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
class OfficeControllerTest {
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private OfficeService officeService;
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void filterShouldReturnSuccess() throws Exception {
        OfficeRequestDto officeRequestDto = new OfficeRequestDto(1,"Fest","8495000002", true);
        List<OfficeResponseDto> list = officeService.filter(officeRequestDto);
        mockMvc.perform(post("/api/office/list")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(officeRequestDto))
        ).andExpect(status().isOk())
                .andExpect(jsonPath("$.data[0].id", is(list.get(0).getId())))
                .andExpect(jsonPath("$.data[0].name", is(list.get(0).getName())))
                .andExpect(jsonPath("$.data[0].isActive", is(list.get(0).asActive())));
    }

    @Test
    public void filterShouldReturnErrorWhenRequestIsIncorrect() throws Exception {
        OfficeRequestDto officeRequestDto = new OfficeRequestDto(1,"Festkk","89097777777", true);
        List<OfficeResponseDto> list = officeService.filter(officeRequestDto);
        mockMvc.perform(post("/api/office/list")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(officeRequestDto)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data", is(list)));
    }

    @Test
    public void loadByIdShouldReturnSuccess() throws Exception {
        OfficeUpdateDto officeUpdateDto = officeService.loadById(2);
        mockMvc.perform(
                get("/api/office/2")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data.name", is(officeUpdateDto.getName())))
                .andExpect(jsonPath("$.data.address", is(officeUpdateDto.getAddress())))
                .andExpect(jsonPath("$.data.phone", is(officeUpdateDto.getPhone())))
                .andExpect(jsonPath("$.data.isActive", is(officeUpdateDto.asActive())));
    }

    @Test
    public void loadByIdShouldReturnErrorWhenGetNotExistedOffice() throws Exception {
        mockMvc.perform(
                get("/api/office/5"))
                .andExpect(status().is5xxServerError())
                .andExpect(mvcResult -> mvcResult.getResolvedException()
                        .getClass().equals(NullPointerException.class));
    }

    @Test
    void saveShouldReturnSuccess() throws Exception{
        OfficeSaveDto officeSaveDto = new OfficeSaveDto(1,"Rio", "Lenina street","89991112211",true);
        mockMvc.perform(post("/api/office/save")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(officeSaveDto)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data.result", is("success")));
    }

    @Test
    void saveShouldReturnErrorWhenRequestIsIncorrect() throws Exception{
        OfficeSaveDto officeSaveDto = new OfficeSaveDto("Rio");
        mockMvc.perform(post("/api/office/save")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(officeSaveDto)))
                .andExpect(status().is5xxServerError());
    }


    @Test
    void updateShouldReturnSuccess() throws Exception{
        OfficeUpdateDto officeUpdateDto = new OfficeUpdateDto(2,"Rio", "Lenina street","89991112211",true);
        mockMvc.perform(post("/api/office/update")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(officeUpdateDto)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data.result", is("success")));
    }

    @Test
    void updateShouldReturnErrorWhenGetNotExistedOffice() throws Exception{
        OfficeUpdateDto officeUpdateDto = new OfficeUpdateDto(10,"Rio", "Lenina street","89991112211",true);
        mockMvc.perform(post("/api/office/update")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(officeUpdateDto)))
                .andExpect(status().is5xxServerError());
    }

    @Test
    void updateShouldReturnErrorWhenRequestIsIncorrect() throws Exception{
        OfficeUpdateDto officeUpdateDto = new OfficeUpdateDto(2,"Rio");
        mockMvc.perform(post("/api/office/update")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(officeUpdateDto)))
                .andExpect(status().is5xxServerError());
    }
}


