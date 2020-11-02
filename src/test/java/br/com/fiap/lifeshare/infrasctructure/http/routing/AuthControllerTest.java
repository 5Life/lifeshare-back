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
class AuthControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldUserToConnect() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders.post("/api/auth")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(UserDTOFixture.getUserLogin())
        ).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void shouldntUserToConnect() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders.post("/api/auth")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(UserDTOFixture.getUserWithBadCredentials())
        ).andExpect(MockMvcResultMatchers.status().isBadRequest());
    }
}
