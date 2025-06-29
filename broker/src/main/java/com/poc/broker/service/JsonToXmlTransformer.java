package com.poc.broker.service;

import com.poc.common.model.PaymentRequest;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;
import org.springframework.stereotype.Component;

import java.io.StringWriter;

@Component
public class JsonToXmlTransformer {
    public String transform(PaymentRequest request) throws Exception {
        JAXBContext context = JAXBContext.newInstance(PaymentRequest.class);
        Marshaller marshaller = context.createMarshaller();
        StringWriter writer = new StringWriter();
        marshaller.marshal(request, writer);
        return writer.toString();
    }
}
