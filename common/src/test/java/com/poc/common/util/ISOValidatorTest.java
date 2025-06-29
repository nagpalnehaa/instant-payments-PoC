package com.poc.common.util;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ISOValidatorTest {

    @Test
    void validCountryShouldPass() {
        assertTrue(ISOValidator.isValidCountry("USA"));
    }

    @Test
    void invalidCountryShouldFail() {
        assertFalse(ISOValidator.isValidCountry("XYZ"));
    }

    @Test
    void validCurrencyShouldPass() {
        assertTrue(ISOValidator.isValidCurrency("EUR"));
    }

    @Test
    void invalidCurrencyShouldFail() {
        assertFalse(ISOValidator.isValidCurrency("BLAH"));
    }
}
