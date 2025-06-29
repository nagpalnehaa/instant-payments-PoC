package com.poc.common.model;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "fraudCheckResult")
public class FraudCheckResult {
    private String status;
    private String message;

    public FraudCheckResult() {
    	
    }

    public FraudCheckResult(String status, String message) {
        this.status = status;
        this.message = message;
    }

    @XmlElement
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    @XmlElement
    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }
}
