package com.poc.fcs.config;

import com.poc.common.model.PaymentRequest;
import com.poc.common.model.FraudCheckResult;
import jakarta.xml.bind.JAXBContext;
import org.apache.camel.converter.jaxb.JaxbDataFormat;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JaxbConfig {

    @Bean
    public JaxbDataFormat paymentRequestJaxb() throws Exception {
        JAXBContext context = JAXBContext.newInstance(PaymentRequest.class);
        return new JaxbDataFormat(context);
    }

    @Bean
    public JaxbDataFormat fraudCheckResultJaxb() throws Exception {
        JAXBContext context = JAXBContext.newInstance(FraudCheckResult.class);
        return new JaxbDataFormat(context);
    }
}
