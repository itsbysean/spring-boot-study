## Spring Cloud Config Server Example

```bash
./mvnw install dockerfile:build
docker run -p 8888:8888 -t groupadd/spring-boot-config-example
```