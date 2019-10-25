## Spring Cloud Microservice Example

```bash
./mvnw install dockerfile:build
docker run -p 8080:8080 --network=groupadd-network --name=groupadd-microservice -t groupadd/spring-boot-microservice-example
```

if the network not created yet then
```bash
docker network create --driver bridge groupadd-network
```