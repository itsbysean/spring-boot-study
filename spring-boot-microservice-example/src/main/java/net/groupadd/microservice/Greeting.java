package net.groupadd.microservice;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * Created by itsbysean.
 */
@Component
@ConfigurationProperties(prefix = "hello")
@RefreshScope
@Getter
@Setter
public class Greeting implements Serializable {

    private static final long serialVersionUID = 1L;

    private String message;
}
