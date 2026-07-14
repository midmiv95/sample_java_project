package com.example.samplejavaproject.api.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example.samplejavaproject.service.GreetingService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(GreetingController.class)
@Import(com.example.samplejavaproject.api.error.GlobalExceptionHandler.class)
class GreetingControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private GreetingService greetingService;

    @Test
    void greetReturnsMessage() throws Exception {
        when(greetingService.buildGreeting("Alice")).thenReturn("Hello, Alice!");

        mockMvc.perform(get("/api/v1/greetings/Alice"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message").value("Hello, Alice!"));
    }

    @Test
    void greetReturnsBadRequestForTooShortName() throws Exception {
        mockMvc.perform(get("/api/v1/greetings/A"))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.error").value("Validation failed"));
    }
}
