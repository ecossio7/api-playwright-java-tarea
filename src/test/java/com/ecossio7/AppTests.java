package com.ecossio7;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utilities.Logs;


public class AppTests {
    @BeforeEach
    void setUp() {
        Logs.info("Setting up before each test");
    }

    @Test
    void nameTest() {
        Assertions.assertEquals(5, 5);
        Logs.info("Running test: nameTest");
    }

    @AfterEach
    void tearDown() {
        System.out.println("Tearing down after each test");
        Logs.info("Tearing down after each test");
    }
}
