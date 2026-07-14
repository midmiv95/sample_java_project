package com.example.samplejavaproject.api.controller;

import com.example.samplejavaproject.api.dto.GreetingResponse;
import com.example.samplejavaproject.service.GreetingService;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RestController
@RequestMapping("/api/v1/greetings")
public class GreetingController {

    private final GreetingService greetingService;

    public GreetingController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    @GetMapping("/{name}")
    public GreetingResponse greet(
            @PathVariable
            @NotBlank(message = "name must not be blank")
            @Size(min = 2, max = 50, message = "name length must be between 2 and 50")
            String name
    ) {
        return new GreetingResponse(greetingService.buildGreeting(name));
    }
}
