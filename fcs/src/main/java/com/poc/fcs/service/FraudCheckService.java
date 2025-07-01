package com.poc.fcs.service;

import com.poc.common.model.FraudCheckResult;
import com.poc.common.model.PaymentRequest;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class FraudCheckService {

    private static final Set<String> NAMES = Set.of("Mark Imaginary", "Govind Real", "Shakil Maybe", "Chang Imagine");
    private static final Set<String> COUNTRIES = Set.of("CUB", "IRQ", "IRN", "PRK", "SDN", "SYR");
    private static final Set<String> BANKS = Set.of("BANK OF KUNLUN", "KARAMAY CITY COMMERCIAL BANK");
    private static final Set<String> KEYWORDS = new HashSet<>(List.of(
    	    "Artillery Procurement", "Lethal Chemicals payment"
    	));

    public FraudCheckResult evaluate(PaymentRequest req) {
        boolean suspicious = 
            NAMES.contains(req.getPayerName()) ||
            NAMES.contains(req.getPayeeName()) ||
            COUNTRIES.contains(req.getPayerCountryCode()) ||
            COUNTRIES.contains(req.getPayeeCountryCode()) ||
            BANKS.contains(req.getPayerBank()) ||
            BANKS.contains(req.getPayeeBank()) ||
            (req.getPaymentInstruction() != null && KEYWORDS.contains(req.getPaymentInstruction()));

        return suspicious
            ? new FraudCheckResult("REJECTED", "Suspicious payment")
            : new FraudCheckResult("APPROVED", "Nothing found, all okay");
    }
}
