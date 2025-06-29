# 💸 Instant Payments

This project is a **proof of concept** for bank payments using a message-driven architecture. It simulates a real-time fraud screening pipeline using:

- ✅ Spring Boot (REST API)
- ✅ Apache Camel (routing & orchestration)
- ✅ ActiveMQ (messaging backbone)

---

## 🎯 Purpose

- Accept payment requests via REST
- Route and transform messages using Camel
- Apply fraud logic before dispatching to a queue
- Log and audit decisions for traceability

---

## 🧩 Architecture Overview

- **PaymentController**: Accepts payment requests (`POST /payments`)
- **CamelRouteBuilder**: Orchestrates the flow
- **FraudCheckService**: Applies fraud rules (e.g. amount, country, account)
- **AuditLogger**: Logs outcomes
- **ActiveMQ**: Receives processed messages for downstream systems

> See [docs/componentDiagram.md](componentDiagram.png), [docs/activityDiagram.md](activityDiagram.png) and [docs/deploymentOverview.md](deploymentOverview.png) for full UML diagrams and flowcharts.

---


