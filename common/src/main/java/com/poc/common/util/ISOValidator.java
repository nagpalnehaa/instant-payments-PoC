package com.poc.common.util;

import java.util.Set;

public class ISOValidator {

    private static final Set<String> VALID_COUNTRIES = Set.of("USA", "DEU", "FRA", "GBR");
    private static final Set<String> VALID_CURRENCIES = Set.of("USD", "EUR", "GBP");

    public static boolean isValidCountry(String code) {
        return VALID_COUNTRIES.contains(code);
    }

    public static boolean isValidCurrency(String code) {
        return VALID_CURRENCIES.contains(code);
    }
}
