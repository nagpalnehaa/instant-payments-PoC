package com.poc.broker.route;

import com.poc.broker.service.JsonToXmlTransformer;
import com.poc.broker.service.XmlToJsonTransformer;
import com.poc.common.model.FraudCheckResult;
import com.poc.common.model.PaymentRequest;
import com.poc.common.util.AuditLogger;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class BrokerRoute extends RouteBuilder {
    @Override
    public void configure() {
        from("jms:queue:fraud-check-json?connectionFactory=#myConnectionFactory")
            .routeId("json-to-xml")
            .unmarshal().json(PaymentRequest.class)
            .bean(JsonToXmlTransformer.class, "transform")
            .process(exchange -> AuditLogger.log("JSON_TO_XML", exchange.getIn().getBody()))
            .to("jms:queue:fraud-check-xml");

        from("jms:queue:fraud-check-result-xml")
            .routeId("xml-to-json")
            .process(exchange -> {
                String xml = exchange.getIn().getBody(String.class);
                FraudCheckResult result = new XmlToJsonTransformer().transform(xml);
                AuditLogger.log("XML_TO_JSON", result);
                exchange.getIn().setBody(result);
            })
            .marshal().json()
            .to("jms:queue:fraud-check-result-json");
    }
}
