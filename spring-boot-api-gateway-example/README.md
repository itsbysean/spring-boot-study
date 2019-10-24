## Spring Cloud API Gateway(Zuul) Example

```bash
./mvnw install dockerfile:build
docker run -p 8765:8765 --network=groupadd-network --name=groupadd-api-gateway -t groupadd/spring-boot-api-gateway-example
```

if the network not created yet then
```bash
docker network create --driver bridge groupadd-network
```