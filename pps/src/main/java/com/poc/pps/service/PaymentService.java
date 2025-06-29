package com.poc.pps.service;

import com.poc.common.model.PaymentRequest;
import com.poc.common.util.AuditLogger;
import com.poc.common.util.ISOValidator;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    private final JmsTemplate jmsTemplate;

    public PaymentService(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    public void process(PaymentRequest request) {
        validate(request);
        AuditLogger.log("VALIDATION_COMPLETE", request);
        jmsTemplate.convertAndSend("fraud-check-json", request);
        AuditLogger.log("MESSAGE_SENT_TO_BROKER", request);
    }

    private void validate(PaymentRequest r) {
        if (!ISOValidator.isValidCountry(r.getPayerCountryCode()) ||
            !ISOValidator.isValidCountry(r.getPayeeCountryCode())) {
            throw new IllegalArgumentException("Invalid ISO country code");
        }

        if (!ISOValidator.isValidCurrency(r.getCurrency())) {
            throw new IllegalArgumentException("Invalid ISO currency code");
        }
    }
}
