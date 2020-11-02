package br.com.fiap.lifeshare.infrasctructure.http.routing;

import org.junit.Before;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
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

import br.com.fiap.lifeshare.infrasctructure.http.presentation.request.DonationDTOFixture;

@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(OrderAnnotation.class)
public class DonationControllerTest {

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
    @WithMockUser("abc@gmail.com")
    @Order(1)
    void shouldCreateNewDonation() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders.post("/api/user/donation")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(DonationDTOFixture.getDonationCreate())
        ).andExpect(MockMvcResultMatchers.status().isCreated());
    }

    @Test
    @WithMockUser("abc@gmail.com")
    @Order(2)
    void shouldNotCreateNewDonationWithoutAValidUser() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders.post("/api/user/donation")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(DonationDTOFixture.getDonationCreateWrongUser())
        ).andExpect(MockMvcResultMatchers.status().isInternalServerError());
    }
    
    @Test
    @WithMockUser("abc@gmail.com")
    @Order(3)
    void shouldUpdateDonation() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders.put("/api/user/donation")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(DonationDTOFixture.getDonationUpdate())
        ).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    @WithMockUser("abc@gmail.com")
    @Order(4)
    void shouldNotUpdateNonExistantDonation() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders.put("/api/user/donation")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(DonationDTOFixture.getDonationNonExistant())
        ).andExpect(MockMvcResultMatchers.status().isInternalServerError());
    }

    @Test
    @WithMockUser("abc@gmail.com")
    @Order(5)
    void shouldDeleteDonation() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders.delete("/api/user/donation")
                        .contentType(MediaType.APPLICATION_JSON)
                        .param("id", "1")
        ).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    @WithMockUser("abc@gmail.com")
    @Order(6)
    void shouldNotDeleteNonExistantDonation() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders.delete("/api/user/donation")
                        .contentType(MediaType.APPLICATION_JSON)
                        .param("id", "2")
        ).andExpect(MockMvcResultMatchers.status().isInternalServerError());
    }
}
