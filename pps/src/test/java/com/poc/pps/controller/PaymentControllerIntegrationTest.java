package com.poc.pps.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.poc.common.model.PaymentRequest;
import com.poc.pps.service.PaymentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(PaymentController.class)
class PaymentControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PaymentService service;

    @Autowired
    private ObjectMapper mapper;

   // @Test
    void shouldReturnOkOnValidRequest() throws Exception {
        PaymentRequest req = new PaymentRequest("A", "B", "USD", "USA", "DEU", "", "");
        mockMvc.perform(post("/api/payments")
                .contentType("application/json")
                .content(mapper.writeValueAsString(req)))
                .andExpect(status().isOk());
    }
}
