flowchart TB
  subgraph User Layer
    User["Client\n(Postman/Web App)"]
  end

  subgraph Application Layer [Spring Boot App]
    Controller["PaymentController"]
    Route["CamelRouteBuilder"]
    FraudLogic["FraudCheckRoute"]
    Logger["AuditLogger"]
  end

  subgraph Integration Layer
    Broker["ActiveMQ"]
  end

  subgraph Infrastructure
    DB["Audit DB"]
    Runtime["Host: Docker/K8s"]
  end

  %% Interactions
  User --> Controller
  Controller --> Route
  Route --> FraudLogic
  FraudLogic --> Logger
  Logger --> DB
  Route --> Broker

  %% Deployment mapping
  Controller --> Runtime
  Route --> Runtime
  FraudLogic --> Runtime
  Logger --> Runtime
