package br.com.fiap.lifeshare.infrasctructure.http.routing;

import br.com.fiap.lifeshare.infrasctructure.http.presentation.request.UserDTOFixture;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {

    @Autowired
    MockMvc mockMvc;


    @Test
    void shouldCreateNewUser() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders.post("/api/user")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(UserDTOFixture.getNewUser())
        ).andExpect(MockMvcResultMatchers.status().isCreated());
    }

    @Test
    void shouldntCreateNewUser() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders.post("/api/user")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(UserDTOFixture.getUserWithoutPassword())
        ).andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    void userAlreadyExists() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders.post("/api/user")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(UserDTOFixture.getCreatedUser())
        ).andExpect(MockMvcResultMatchers.status().isOk());
    }
}
