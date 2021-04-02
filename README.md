# Introduce

This is service to integrate with those 3rd parties to purchase prepaid data of SIM card. Below is the main stream of services. Service have 3 Module:
  - First, this is RestFull API to recive request from customer and response voucher to customer via RestAPI or SMS. 
  - Second is module to create http request to 3rd parties to retive voucher and handle response of 3rd parties.
  - Third is message queue broker (RabbitMQ) to transformation and routing messages mediate between RestFull API and module second.

![Alt Text](/MainFlow.png)

# Technology Use

- Spring boot, Spring data JPA,Maven, MySQL, RabbitMQ, JUnit
- WireMock to mock API 3re parties

## Installation

- Inner folder 'ProviderVoucherWireMock'. excute command to run WireMock. Property --port to specific port ( I use port 9999)

```bash
java -jar wiremock-standalone-2.27.2.jar --port 9999
```

- Spring boot app, RestAPI will run in port 2912. (http://localhost:2912/swagger-ui.html)

```bash
mvn spring-boot:run
```

