package br.com.fiap.lifeshare.component;

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
    void shouldReturnBadCredentials() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders.post("/api/auth")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content("{\"email\": \"test@test.com\", \"senha\": \"test123\" }")
        ).andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    void shouldReturnOk() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders.post("/api/auth")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{ \"email\": \"abc@gmail.com\", \"senha\": \"abc123\" }")
        ).andExpect(MockMvcResultMatchers.status().isOk());
    }
}
