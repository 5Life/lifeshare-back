package br.com.fiap.lifeshare.infrasctructure.http.routing;

import br.com.fiap.lifeshare.infrasctructure.http.presentation.request.UserDTOFixture;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders
            .webAppContextSetup(webApplicationContext)
            .apply(SecurityMockMvcConfigurers.springSecurity())
            .build();
    }

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

    @WithMockUser("abc@gmail.com")
    @Test
    void shouldUpdateUser() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders.put("/api/user")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(UserDTOFixture.getUpdatedUser())
        ).andExpect(MockMvcResultMatchers.status().isCreated());
    }

    @WithMockUser("abc@gmail.com")
    @Test
    void shouldNotUpdateUser() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders.put("/api/user")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(UserDTOFixture.getUpdatedUserNotExistent())
        ).andExpect(MockMvcResultMatchers.status().isOk());
    }
}
