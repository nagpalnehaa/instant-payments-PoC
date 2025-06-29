package com.poc.broker.service;

import com.poc.common.model.FraudCheckResult;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Unmarshaller;
import org.springframework.stereotype.Component;

import java.io.StringReader;

@Component
public class XmlToJsonTransformer {
    public FraudCheckResult transform(String xml) throws Exception {
        JAXBContext context = JAXBContext.newInstance(FraudCheckResult.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        return (FraudCheckResult) unmarshaller.unmarshal(new StringReader(xml));
    }
}
