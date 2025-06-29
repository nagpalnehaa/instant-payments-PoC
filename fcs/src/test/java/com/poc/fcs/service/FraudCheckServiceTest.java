package com.poc.fcs.service;

import com.poc.common.model.FraudCheckResult;
import com.poc.common.model.PaymentRequest;
import com.poc.fcs.service.FraudCheckService;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FraudCheckServiceTest {

    private final FraudCheckService service = new FraudCheckService();

    //@Test
    void suspiciousNameShouldBeRejected() {
        PaymentRequest req = new PaymentRequest("Govind Real", "Bob", "EUR", "DEU", "FRA", "test", "ING");
        FraudCheckResult result = service.evaluate(req);
        assertEquals("REJECTED", result.getStatus());
    }

    //@Test
    void cleanPaymentShouldBeApproved() {
        PaymentRequest req = new PaymentRequest("Alice", "Bob", "EUR", "DEU", "FRA", "rent", "Deutsche Bank");
        FraudCheckResult result = service.evaluate(req);
        assertEquals("APPROVED", result.getStatus());
    }
}
