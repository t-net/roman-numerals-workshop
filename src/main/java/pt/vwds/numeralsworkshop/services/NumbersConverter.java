package pt.vwds.numeralsworkshop.services;

public class NumbersConverter {

    public static String toRomanNumeral(int number) {
        if (number < 1 || number > 3999) {
            throw new IllegalArgumentException("Number should be larger than 0 and smaller than 4000");
        }
        String ones = romanNumeral(number % 10, "I", "V", "X");

        String tens = romanNumeral(number / 10 % 10, "X", "L", "C");

        String hundreds = romanNumeral(number / 100 % 10, "C", "D", "M");

        String thousands = romanNumeral(number / 1000 % 10, "M", "", "");

        return thousands + hundreds + tens + ones;
    }

    private static String romanNumeral(int n, String one, String five, String ten) {
        if (n < 1) {
            return "";
        }
        if (n <= 3) {
            return one.repeat(n);
        } else if (n == 4) {
            return one + five;
        } else if (n == 5) {
            return five;
        } else if (n <= 8) {
            return five + one.repeat(n - 5);
        } else if (n == 9) {
            return one + ten;
        }
        return "";
    }
}
