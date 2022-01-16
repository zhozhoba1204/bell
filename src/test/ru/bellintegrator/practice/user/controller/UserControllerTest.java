package ru.bellintegrator.practice.user.controller;

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
import ru.bellintegrator.practice.user.dto.UserRequestDto;
import ru.bellintegrator.practice.user.dto.UserResponseDto;
import ru.bellintegrator.practice.user.dto.UserSaveDto;
import ru.bellintegrator.practice.user.dto.UserUpdateDto;
import ru.bellintegrator.practice.user.service.UserService;
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
class UserControllerTest {
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private UserService userService;
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void filterShouldReturnSuccess() throws Exception {
        UserRequestDto userRequestDto = new UserRequestDto(2);
        List<UserResponseDto> list = userService.filter(userRequestDto);
        mockMvc.perform(post("/api/user/list")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(userRequestDto))
                ).andExpect(status().isOk())
                .andExpect(jsonPath("$.data[0].id", is(list.get(0).getId())))
                .andExpect(jsonPath("$.data[0].firstName", is(list.get(0).getFirstName())));
    }

    @Test
    public void filterShouldReturnErrorWhenOrgIdIsIncorrect() throws Exception {
        UserRequestDto userRequestDto = new UserRequestDto(5);
        List<UserResponseDto> list = userService.filter(userRequestDto);
        mockMvc.perform(post("/api/user/list")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(list)))
                .andExpect(status().is5xxServerError())
                .andExpect(mvcResult -> mvcResult.getResolvedException()
                        .getClass().equals(NullPointerException.class));
    }

    @Test
    public void loadByIdShouldReturnSuccess() throws Exception {
        UserUpdateDto userUpdateDto = userService.loadById(1);
        mockMvc.perform(
                        get("/api/user/2")
                                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data.firstName", is(userUpdateDto.getFirstName())))
                .andExpect(jsonPath("$.data.secondName", is(userUpdateDto.getSecondName())))
                .andExpect(jsonPath("$.data.officeId", is(userUpdateDto.getOfficeId())))
                .andExpect(jsonPath("$.data.docDate", is(userUpdateDto.getDocDate())));
    }

    @Test
    public void loadByIdShouldReturnErrorWhenGetNotExistedUser() throws Exception {
        mockMvc.perform(
                        get("/api/user/5"))
                .andExpect(status().is5xxServerError())
                .andExpect(mvcResult -> mvcResult.getResolvedException()
                        .getClass().equals(NullPointerException.class));
    }

    @Test
    void saveShouldReturnSuccess() throws Exception{
        UserSaveDto userSaveDto = new UserSaveDto(2,"Ivan","Ivanov","Ivanovich","supervisor","89099876542",
                "zagran","789456","12 APRIL 2020","222", true);
        mockMvc.perform(post("/api/user/save")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(userSaveDto)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data.result", is("success")));
    }

    @Test
    void saveShouldReturnErrorWhenRequestIsIncorrect() throws Exception{
        UserSaveDto userSaveDto = new UserSaveDto("Ivan");
        mockMvc.perform(post("/api/user/save")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(userSaveDto)))
                .andExpect(status().is5xxServerError());
    }


    @Test
    void updateShouldReturnSuccess() throws Exception{
        UserUpdateDto userUpdateDto = new UserUpdateDto(1,2,"Ivan","Ivanov",
                "Ivanivich", "driver","89091234555","zagran","123000",
                "1 SEPTEMBER 2020","633",true);
        mockMvc.perform(post("/api/user/update")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(userUpdateDto)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data.result", is("success")));
    }

    @Test
    void updateShouldReturnErrorWhenGetNotExistedUser() throws Exception{
        UserUpdateDto userUpdateDto = new UserUpdateDto(10,2,"Ivan","Ivanov",
                "Ivanovich", "driver","89091234555","zagran","123000",
                "1 SEPTEMBER 2020","633",true);       
        mockMvc.perform(post("/api/user/update")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(userUpdateDto)))
                .andExpect(status().is5xxServerError());
    }

    @Test
    void updateShouldReturnErrorWhenRequestIsIncorrect() throws Exception{
        UserUpdateDto userUpdateDto = new UserUpdateDto(2,"Vasya");
        mockMvc.perform(post("/api/user/update")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(userUpdateDto)))
                .andExpect(status().is5xxServerError());
    }
}
