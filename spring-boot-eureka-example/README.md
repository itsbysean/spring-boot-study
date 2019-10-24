## Spring Cloud Eureka Server Example

```bash
./mvnw install dockerfile:build
docker run -p 8761:8761 --network=groupadd-network --name=groupadd-eureka -t groupadd/spring-boot-eureka-example
```

if the network not created yet then
```bash
docker network create --driver bridge groupadd-network
```