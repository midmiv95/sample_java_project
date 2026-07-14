package com.example.samplejavaproject.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class GreetingServiceTest {

    private final GreetingService greetingService = new GreetingService();

    @Test
    void buildGreetingReturnsExpectedMessage() {
        assertEquals("Hello, Alice!", greetingService.buildGreeting("Alice"));
    }

    @Test
    void buildGreetingTrimsInput() {
        assertEquals("Hello, Bob!", greetingService.buildGreeting("  Bob  "));
    }
}
