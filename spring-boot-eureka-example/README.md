## Spring Cloud Eureka Server Example

```bash
./mvnw install dockerfile:build
docker run -p 8761:8761 -t groupadd/spring-boot-eureka-example
```