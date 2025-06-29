package com.poc.fcs.route;

import com.poc.common.model.FraudCheckResult;
import com.poc.common.model.PaymentRequest;
import com.poc.common.util.AuditLogger;
import com.poc.fcs.service.FraudCheckService;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.converter.jaxb.JaxbDataFormat;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class FraudCheckRoute extends RouteBuilder {

    private final JaxbDataFormat paymentRequestJaxb;
    private final JaxbDataFormat fraudCheckResultJaxb;

    public FraudCheckRoute(
        @Qualifier("paymentRequestJaxb") JaxbDataFormat paymentRequestJaxb,
        @Qualifier("fraudCheckResultJaxb") JaxbDataFormat fraudCheckResultJaxb
    ) {
        this.paymentRequestJaxb = paymentRequestJaxb;
        this.fraudCheckResultJaxb = fraudCheckResultJaxb;
    }

    @Override
    public void configure() throws Exception {
        from("jms:queue:fraud-check-xml")
            .routeId("xml-consumer")
            .unmarshal(paymentRequestJaxb)
            .bean(FraudCheckService.class, "evaluate")
            .process(exchange ->
                AuditLogger.log("FRAUD_ANALYSIS_RESULT", exchange.getIn().getBody())
            )
            .marshal(fraudCheckResultJaxb)
            .to("jms:queue:fraud-check-result-xml");
    }
}
