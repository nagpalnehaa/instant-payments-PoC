graph TD
  Controller["PaymentController (Solution 1)"]
  CamelRoute["Camel RouteBuilder"]
  FraudLogic["FraudCheckProcessor (Solution 2)"]
  Audit["AuditLogger"]
  ActiveMQ["ActiveMQ Broker"]

  Controller --> CamelRoute
  CamelRoute --> FraudLogic
  FraudLogic --> Audit
  CamelRoute --> ActiveMQ
