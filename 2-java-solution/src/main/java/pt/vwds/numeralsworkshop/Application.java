package pt.vwds.numeralsworkshop;

import pt.vwds.numeralsworkshop.services.NumeralsService;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = reader.nextInt();
        System.out.println("Roman numeral: " + NumeralsService.toRomanNumeral(number));

        reader.close();
    }
}