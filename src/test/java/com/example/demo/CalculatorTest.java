package com.example.demo;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

//    @Disabled
    @Test
    public void add() {

        Calculator c = new Calculator();
        int r = c.add(1, 2);

        assertEquals(3, r, "有問題");
        assertTrue(r > 1);
    }

    @DisplayName("測試除法問題")
    @Test
    public void divide() {

        Calculator c = new Calculator();

        assertThrows(ArithmeticException.class, () -> {
            c.divide(1, 0);
        });
    }
}