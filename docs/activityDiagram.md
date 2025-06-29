flowchart TD
  A[POST Payment Received] --> B[Validate Payload]
  B --> C[FraudCheckProcessor]
  C --> D{Is Suspicious?}
  D -- Yes --> E[Log + Flag]
  D -- No --> F[Log + Accept]
  E & F --> G[Send to ActiveMQ queue]
  G --> H[Respond to Client]
