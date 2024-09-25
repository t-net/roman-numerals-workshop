package pt.vwds.numeralsworkshop.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

public class NumeralsServiceTest {

    private static Stream<Arguments> getArgumentsForToRomanNumeral() {
        return Stream.of(
                Arguments.of(1, "I"),
                Arguments.of(2, "II"),
                Arguments.of(3, "III"),
                Arguments.of(4, "IV"),
                Arguments.of(5, "V"),
                Arguments.of(6, "VI"),
                Arguments.of(7, "VII"),
                Arguments.of(8, "VIII"),
                Arguments.of(9, "IX"),
                Arguments.of(10, "X"),
                Arguments.of(11, "XI"),
                Arguments.of(12, "XII"),
                Arguments.of(13, "XIII"),
                Arguments.of(14, "XIV"),
                Arguments.of(15, "XV"),
                Arguments.of(16, "XVI"),
                Arguments.of(17, "XVII"),
                Arguments.of(18, "XVIII"),
                Arguments.of(19, "XIX"),
                Arguments.of(20, "XX"),
                Arguments.of(21, "XXI"),
                Arguments.of(22, "XXII"),
                Arguments.of(23, "XXIII"),
                Arguments.of(24, "XXIV"),
                Arguments.of(30, "XXX"),
                Arguments.of(40, "XL"),
                Arguments.of(50, "L"),
                Arguments.of(60, "LX"),
                Arguments.of(70, "LXX"),
                Arguments.of(80, "LXXX"),
                Arguments.of(90, "XC"),
                Arguments.of(100, "C"),
                Arguments.of(101, "CI"),
                Arguments.of(102, "CII"),
                Arguments.of(200, "CC"),
                Arguments.of(300, "CCC"),
                Arguments.of(400, "CD"),
                Arguments.of(500, "D"),
                Arguments.of(600, "DC"),
                Arguments.of(700, "DCC"),
                Arguments.of(800, "DCCC"),
                Arguments.of(900, "CM"),
                Arguments.of(1000, "M"),
                Arguments.of(1001, "MI"),
                Arguments.of(1002, "MII"),
                Arguments.of(1900, "MCM"),
                Arguments.of(2000, "MM"),
                Arguments.of(2001, "MMI"),
                Arguments.of(2002, "MMII"),
                Arguments.of(2100, "MMC"),
                Arguments.of(3000, "MMM"),
                Arguments.of(3999, "MMMCMXCIX")
        );
    }

    @ParameterizedTest(name = "expected roman numeral {1} for given arabic numeral {0}")
    @MethodSource("getArgumentsForToRomanNumeral")
    @DisplayName("toRomanNumeral - Should return Roman numeral for a given Arabic numeral")
    void toRomanNumeral_shouldReturnRomanNumerals(int given, String expected) {
        Assertions.assertEquals(expected, NumeralsService.toRomanNumeral(given));
    }

    @ParameterizedTest(name = "expected error for given arabic numeral {0}")
    @ValueSource(ints = {0, -1, -100})
    @DisplayName("toRomanNumeral - Should throw an error for numerals smaller than 1")
    void toRomanNumeral_shouldThrowAnErrorForSmallerThan1(int given) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> NumeralsService.toRomanNumeral(given));
    }

    @ParameterizedTest(name = "expected error for given arabic numeral {0}")
    @ValueSource(ints = {4000, 4999, 10000})
    @DisplayName("toRomanNumeral - Should throw an error for numerals larger than 3999")
    void toRomanNumeral_shouldThrowAnErrorForBiggerThan3999(int given) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> NumeralsService.toRomanNumeral(given));
    }
}
