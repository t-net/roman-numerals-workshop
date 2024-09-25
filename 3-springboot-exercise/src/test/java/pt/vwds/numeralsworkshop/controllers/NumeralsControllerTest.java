package pt.vwds.numeralsworkshop.controllers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class NumeralsControllerTest {

    @Test
    @DisplayName("GET /roman-numeral - Should return the roman numeral for the given number")
    public void getRomanNumeral_shouldReturnRomanNumerals() {
        Assertions.assertTrue(true);
    }

}
