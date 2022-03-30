package ru.bellintegrator.practice.citizenship.controller;

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
import ru.bellintegrator.practice.citizenship.dto.CitizenshipDto;
import ru.bellintegrator.practice.citizenship.service.CitizenshipService;
import java.util.List;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = PracticeApplication.class)
@TestPropertySource(locations = "/application-test.properties")
@Sql(scripts = {"/test-schema.sql", "/test-data.sql"})
@AutoConfigureMockMvc
class CitizenshipControllerTest {
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private CitizenshipService citizenshipService;
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void allShouldReturnSuccess() throws Exception {
        List<CitizenshipDto> list = citizenshipService.all();
        mockMvc.perform(post("/api/countries/allcounries")
                        .contentType(MediaType.APPLICATION_JSON)
                ).andExpect(status().isOk())
                .andExpect(jsonPath("$.data[0].name", is(list.get(0).getName())))
                .andExpect(jsonPath("$.data[0].code", is(list.get(0).getCode())))
                .andExpect(jsonPath("$.data[1].name", is(list.get(1).getName())))
                .andExpect(jsonPath("$.data[1].code", is(list.get(1).getCode())));
    }
}