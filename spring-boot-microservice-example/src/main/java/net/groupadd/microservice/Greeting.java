package net.groupadd.microservice;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

/**
 * Created by itsbysean.
 */
@Component
@ConfigurationProperties("hello")
@RefreshScope
@Data
public class Greeting {
    private String message;
}
