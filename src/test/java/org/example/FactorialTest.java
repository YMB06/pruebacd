package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;

class FactorialTest {
    static Factorial factorial;
    @BeforeEach
    void setUp() {
        factorial = new Factorial();
    }

    @AfterEach
    void tearDown() {
    }

    @ParameterizedTest
    @CsvSource({"0,1", "1,1", "2,2", "3,6", "4,24", "5,120", "6,720", "7,5040", "8,40320", "9,362880", "10,3628800"})
    void calculo() {
        int result = factorial.calculo(5);
        assertEquals(120, result);
    }
}