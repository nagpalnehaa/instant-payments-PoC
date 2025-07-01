package com.poc.common.model;

import java.io.Serializable;
import jakarta.validation.constraints.*;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "paymentRequest")
@XmlAccessorType(XmlAccessType.FIELD)
public class PaymentRequest {

	@NotNull(message = "Transaction ID is required")
	@Pattern(regexp = "^[0-9a-fA-F-]{36}$", message = "Transaction ID must be a valid UUID")
	@XmlElement
	private String transactionId;

	@NotBlank(message = "Payer name is required")
	@XmlElement
	private String payerName;

	@NotBlank(message = "Payer bank is required")
	@XmlElement
	private String payerBank;

	@NotBlank(message = "Payer country code is required")
	@Pattern(regexp = "^[A-Z]{3}$", message = "Must be ISO alpha-3 code")
	@XmlElement
	private String payerCountryCode;

	@NotBlank(message = "Payer account is required")
	@XmlElement
	private String payerAccount;

	@NotBlank(message = "Payee name is required")
	@XmlElement
	private String payeeName;

	@NotBlank(message = "Payee bank is required")
	@XmlElement
	private String payeeBank;

	@NotBlank(message = "Payee country code is required")
	@Pattern(regexp = "^[A-Z]{3}$", message = "Must be ISO alpha-3 code")
	@XmlElement
	private String payeeCountryCode;

	@NotBlank(message = "Payee account is required")
	@XmlElement
	private String payeeAccount;

	@XmlElement
	private String paymentInstruction; // Optional

	@NotNull(message = "Execution date is required")
	@Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}$", message = "Must be YYYY-MM-DD format")
	@XmlElement
	private String executionDate;

	@NotNull(message = "Amount is required")
	@DecimalMin(value = "0.01", message = "Amount must be greater than 0")
	@XmlElement
	private Double amount;

	@NotBlank(message = "Currency is required")
	@Pattern(regexp = "^[A-Z]{3}$", message = "Must be ISO 4217 currency code")
	@XmlElement
	private String currency;

	@NotBlank(message = "Creation timestamp is required")
	@Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}T\\d{2}:\\d{2}:\\d{2}Z$", message = "Must be ISO 8601 UTC format (e.g. 2004-02-21T17:00:00Z)")

	@XmlElement
	private String creationTimestamp;

	public PaymentRequest() {

	}

	public PaymentRequest(String payerName, String payeeName, String currency, String payerCountryCode,
			String payeeCountryCode, String paymentInstruction, String payerBank) {
		this.payerName = payerName;
		this.payeeName = payeeName;
		this.currency = currency;
		this.payerCountryCode = payerCountryCode;
		this.payeeCountryCode = payeeCountryCode;
		this.paymentInstruction = paymentInstruction;
		this.payerBank = payerBank;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public String getPayerName() {
		return payerName;
	}

	public void setPayerName(String payerName) {
		this.payerName = payerName;
	}

	public String getPayerBank() {
		return payerBank;
	}

	public void setPayerBank(String payerBank) {
		this.payerBank = payerBank;
	}

	public String getPayerCountryCode() {
		return payerCountryCode;
	}

	public void setPayerCountryCode(String payerCountryCode) {
		this.payerCountryCode = payerCountryCode;
	}

	public String getPayerAccount() {
		return payerAccount;
	}

	public void setPayerAccount(String payerAccount) {
		this.payerAccount = payerAccount;
	}

	public String getPayeeName() {
		return payeeName;
	}

	public void setPayeeName(String payeeName) {
		this.payeeName = payeeName;
	}

	public String getPayeeBank() {
		return payeeBank;
	}

	public void setPayeeBank(String payeeBank) {
		this.payeeBank = payeeBank;
	}

	public String getPayeeCountryCode() {
		return payeeCountryCode;
	}

	public void setPayeeCountryCode(String payeeCountryCode) {
		this.payeeCountryCode = payeeCountryCode;
	}

	public String getPayeeAccount() {
		return payeeAccount;
	}

	public void setPayeeAccount(String payeeAccount) {
		this.payeeAccount = payeeAccount;
	}

	public String getPaymentInstruction() {
		return paymentInstruction;
	}

	public void setPaymentInstruction(String paymentInstruction) {
		this.paymentInstruction = paymentInstruction;
	}

	public String getExecutionDate() {
		return executionDate;
	}

	public void setExecutionDate(String executionDate) {
		this.executionDate = executionDate;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getCreationTimestamp() {
		return creationTimestamp;
	}

	public void setCreationTimestamp(String creationTimestamp) {
		this.creationTimestamp = creationTimestamp;
	}
}
