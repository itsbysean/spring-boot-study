## Spring Cloud Config Server Example

```bash
./mvnw install dockerfile:build
docker run -p 8888:8888 --network=groupadd-network --name=groupadd-config -t groupadd/spring-boot-config-example
```

if the network not created yet then
```bash
docker network create --driver bridge groupadd-network
```