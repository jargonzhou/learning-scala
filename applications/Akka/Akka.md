# Akka
* https://akka.io/
* https://github.com/akka/akka

> Akka is a powerful platform that simplifies building and operating highly responsive, resilient, and scalable services.
>
> The platform consists of
>
> - the Akka SDK for straightforward, rapid development with AI assist and automatic clustering. Services built with the Akka SDK are automatically clustered and can be deployed on any infrastructure. and
> - Akka Automated Operations, a managed solution that handles everything for Akka SDK services from auto-elasticity to multi-region high availability running safely within your VPC.

# Books
* https://doc.akka.io/libraries/akka-core/current/additional/books.html
* Raymond Roestenburg, Rob Bakker, Rob Williams. **Akka in Action**, Manning: 2017.

# See Also
* [Akka (toolkit) - wikipedia](https://en.wikipedia.org/wiki/Akka_(toolkit))
* [Actor Model](https://en.wikipedia.org/wiki/Carl_Hewitt#Actor_model)
* Acotor Model paper: A Universal Modular Actor Formalism for Artificial Intelligence(1973).

# EIP: Enterprise Integration Patterns
* [EIP: Enterprise Integration Patterns](https://www.enterpriseintegrationpatterns.com/)

| Category               | Name                        | Description |
| ---------------------- | --------------------------- | ----------- |
| Integration Styles     | File Transfer               |             |
|                        | Shared Database             |             |
|                        | Remote Procedure Invocation |             |
|                        | Messaging                   |             |
| Messaging Endpoints    | Message Endpoint            |             |
|                        | Messaging Gateway           |             |
|                        | Messaging Mapper            |             |
|                        | Transactional Client        |             |
|                        | Polling Consumer            |             |
|                        | Event-driven Consumer       |             |
|                        | Competing Consumers         |             |
|                        | Message Dispatcher          |             |
|                        | Selective Consumer          |             |
|                        | Durable Subscriber          |             |
|                        | Idempotent Receiver         |             |
|                        | Service Activator           |             |
| Messaging Patterns     | Message                     |             |
|                        | Command Message             |             |
|                        | Document Message            |             |
|                        | Event Message               |             |
|                        | Request-Reply               |             |
|                        | Return Address              |             |
|                        | Correlation Identifier      |             |
|                        | Message Sequence            |             |
|                        | Message Expiration          |             |
|                        | Format Indicator            |             |
| Messaging Channels     | Message Channel             |             |
|                        | Point-to-Point Channel      |             |
|                        | Publish-Subscr. Channel     |             |
|                        | Datatype Channel            |             |
|                        | Invalid Message Channel     |             |
|                        | Dead Letter Channel         |             |
|                        | Guaranteed Delivery         |             |
|                        | Channel Adapter             |             |
|                        | Messaging Bridge            |             |
|                        | Message Bus                 |             |
| Messaging Routing      | Pipes-and-Filters           |             |
|                        | Message Router              |             |
|                        | Content-based Router        |             |
|                        | Message Filter              |             |
|                        | Dynamic Router              |             |
|                        | Recipient List              |             |
|                        | Splitter                    |             |
|                        | Aggregator                  |             |
|                        | Resequencer                 |             |
|                        | Composed Msg. Processor     |             |
|                        | Scatter-Gather              |             |
|                        | Routing Slip                |             |
|                        | Process Manager             |             |
|                        | Message Broker              |             |
| Systems Management     | Control Bus                 |             |
|                        | Detour                      |             |
|                        | Wire Tap                    |             |
|                        | Message History             |             |
|                        | Message Store               |             |
|                        | Smart Proxy                 |             |
|                        | Test Message                |             |
|                        | Channel Purger              |             |
| Message Transformation | Message Translator          |             |
|                        | Envelope Wrapper            |             |
|                        | Content Enricher            |             |
|                        | Content Filter              |             |
|                        | Claim Check                 |             |
|                        | Normalizer                  |             |
|                        | Canonical Data Model        |             |


| Terminology | Description                                                                                                                                                                                                                                   |
| ----------- | --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| STOMP       | Simple Text Oriented Messaging Protocol(https://stomp.github.io/index.html) 1.2 Spec: https://stomp.github.io/stomp-specification-1.2.html 1.2 Release: 2012-10-22 Product: https://stomp.github.io/implementations.html                      |
| AMQP        | Advanced Message Queuing Protocol(http://www.amqp.org/) OASIS AMQP 1.0 standard: http://docs.oasis-open.org/amqp/core/v1.0/os/amqp-core-complete-v1.0-os.pdf OASIS AMQP 1.0 Release: 2012-10-29 Product: http://www.amqp.org/about/examples   |
| MQTT        | MQ Telemetry Transport(http://mqtt.org/faq) OASIS MQTT 3.1.1 Standard: http://docs.oasis-open.org/mqtt/mqtt/v3.1.1/os/mqtt-v3.1.1-os.pdf OASIS MQTT 3.1.1 Release: 2014-10-29 Production: https://github.com/mqtt/mqtt.github.io/wiki/servers |

| Feature        | ActiveMQ | Apollo | RabbitMQ | Kafka |
| -------------- | -------- | ------ | -------- | ----- |
| STMOP          | Y        | Y      | Y        |       |
| AMQP           | Y        |        | Y        |       |
| MQTT           | Y        | Y      | Y        |       |
| REST           | Y        |        | Y        |       |
| MultiLanguage  | Y        | NA     | Y        |       |
| Web Management | Y        | Y      | Y        |       |
| HA             |          |        | Y        |       |
| Security       | JAAS     |        | TLS      |       |
| Persitent      |          |        |          |       |
| Transaction    |          |        |          |       |

