package com.ecossio7;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {
    @BeforeEach
    void setUp() {
        System.out.println("Setting up before each test");

    }

    @Test
    void name() {
        System.out.println("Running test: name");
        Assertions.assertEquals(5, 5);
    }

    @AfterEach
    void tearDown() {
        System.out.println("Tearing down after each test");
    }

}
