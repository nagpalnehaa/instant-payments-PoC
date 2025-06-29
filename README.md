# 💸 Instant Payments

This project simulates real-time instant payments pipeline using **Spring Boot**, **Apache Camel**, and **ActiveMQ**. It models an event-driven flow where each payment request is screened for potential fraud and routed asynchronously for downstream processing.

---

## 🎯 Core Objectives

- Demonstrate an event-driven payment registry (**Solution 1**)
- Embed real-time fraud screening logic in the processing flow (**Solution 2**)
- Provide a clean, extendable blueprint for microservice-based fraud detection

---

## 🛠️ Tech Stack

| Technology     | Functionality                              |
|----------------|---------------------------------------------|
| Spring Boot    | REST API layer and application container    |
| Apache Camel   | Routing, mediation, and integration logic   |
| ActiveMQ       | Asynchronous message broker                 |
| Postman        | API testing and validation                  |
| Maven          | Project build and dependency management     |

---

## 🚀 How It Works

1. Client submits a `POST /payments` request with payment data.
2. **Solution 1:** The request triggers a Camel route that initiates a processing pipeline, based on messaging and JSON.
3. **Solution 2:** The message passes through `FraudCheckService` to flag suspicious activity, based on REST APIs and JSON.
4. The result is logged via `AuditLogger`.
5. The transaction is finally dispatched to an ActiveMQ topic for asynchronous handling.

## 🔄 Communication Flow (Label in Arrows)
PPS → BS: “JSON via JMS / REST”

BS → FCS: “XML via JMS”

FCS → BS: “XML via JMS”

BS → PPS: “Fraud Result (JSON)”


