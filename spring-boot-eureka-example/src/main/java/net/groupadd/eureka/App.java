package net.groupadd.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Created by itsbysean.
 */
@SpringBootApplication
@EnableEurekaServer
public class App {

    public static void main(String...args){
        SpringApplication.run(App.class);
    }
}
