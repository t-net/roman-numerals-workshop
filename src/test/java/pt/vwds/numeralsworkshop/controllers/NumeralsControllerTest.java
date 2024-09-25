package pt.vwds.numeralsworkshop.controllers;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import pt.vwds.numeralsworkshop.services.NumeralsService;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
public class NumeralsControllerTest {

    @MockBean
    private NumeralsService numeralsService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("GET /roman-numeral - Should return the roman numeral for the given number")
    public void getRomanNumeral_shouldReturnRomanNumerals() throws Exception {
        when(numeralsService.toRomanNumeral(999)).thenReturn("mock-roman-numeral");

        mockMvc.perform(get("/roman-numeral/999"))
                .andExpect(status().isOk())
                .andExpect(content().string("mock-roman-numeral"));

        verify(numeralsService, times(1)).toRomanNumeral(999);
    }

    @Test
    @DisplayName("GET /roman-numeral - Should return an error message when the number is invalid")
    public void getRomanNumeral_shouldReturnErrorWhenInvalidNumber() throws Exception {
        when(numeralsService.toRomanNumeral(999)).thenThrow(new IllegalArgumentException("mock-error-message"));

        mockMvc.perform(get("/roman-numeral/999"))
                .andExpect(status().isOk())
                .andExpect(content().string("mock-error-message"));

        verify(numeralsService, times(1)).toRomanNumeral(999);
    }

}
