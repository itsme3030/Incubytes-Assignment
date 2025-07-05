package com.example.TDD.Assignment;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StringCalculatorTestCases {
    private StringCalculator calc;

    @BeforeEach
    void setUp() {
        calc = new StringCalculator();
    }

    //Empty input
    @Test
    void emptyInputReturnsZero() {
        assertEquals(0, calc.add(""));
    }

    // Invalid comma usage
    @Test
    void invalidCommaThrows() {
        assertThrows(RuntimeException.class, () -> calc.add("1,,2"));
    }

    //Invalid newline usage
    @Test
    void invalidNewlineThrows() {
        assertThrows(RuntimeException.class, () -> calc.add("3,\n4"));
    }

    //Sum of comma‑separated numbers
    @Test
    void sumCommaSeparated() {
        assertEquals(14, calc.add("2,4,8"));
    }

    // Empty with custom delimiter
    @Test
    void emptyWithCustomDelimiterReturnsZero() {
        assertEquals(0, calc.add("//;\n"));
    }

    //Sum using custom single‑char delimiter
    @Test
    void sumCustomDelimiter() {
        assertEquals(10, calc.add("//;\n2;3;5"));
    }

    // Multiple negatives listed
    @Test
    void multipleNegativesThrow() {
        IllegalArgumentException ex = assertThrows(
                IllegalArgumentException.class,
                () -> calc.add("5,-1,6,-2")
        );
        assertEquals("negative numbers not allowed <-1,-2>", ex.getMessage());
    }

    // Negatives with custom delimiter
    @Test
    void negativesWithCustomDelimiterThrow() {
        IllegalArgumentException ex = assertThrows(
                IllegalArgumentException.class,
                () -> calc.add("//#\n3#-4#7#-6")
        );
        assertEquals("negative numbers not allowed <-4,-6>", ex.getMessage());
    }
}
