package com.poc.pps.service;

import com.poc.common.model.PaymentRequest;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.jms.core.JmsTemplate;

import static org.junit.jupiter.api.Assertions.*;

class PaymentServiceTest {

    private final JmsTemplate jmsTemplate = Mockito.mock(JmsTemplate.class);
    private final PaymentService service = new PaymentService(jmsTemplate);

   // @Test
    void validPaymentShouldSendToQueue() {
        PaymentRequest request = new PaymentRequest("Alice", "Bob", "USD", "USA", "DEU", "memo", "HSBC");
        assertDoesNotThrow(() -> service.process(request));
        Mockito.verify(jmsTemplate).convertAndSend("fraud-check-json", request);
    }

   // @Test
    void invalidCountryShouldThrowException() {
        PaymentRequest request = new PaymentRequest("A", "B", "XYZ", "XXX", "DEU", "", "");
        assertThrows(IllegalArgumentException.class, () -> service.process(request));
    }
}
