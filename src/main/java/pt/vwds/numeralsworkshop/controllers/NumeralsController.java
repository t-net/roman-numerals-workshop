package pt.vwds.numeralsworkshop.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pt.vwds.numeralsworkshop.services.NumeralsService;

@RestController
public class NumeralsController {

    private final NumeralsService numeralsService;

    public NumeralsController(NumeralsService numeralsService) {
        this.numeralsService = numeralsService;
    }

    @GetMapping("/roman-numeral/{number}")
    public String GetRomanNumeral(@PathVariable("number") int number) {
        return this.numeralsService.toRomanNumeral(number);
    }
}
