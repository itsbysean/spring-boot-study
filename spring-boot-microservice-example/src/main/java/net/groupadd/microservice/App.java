package net.groupadd.microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by itsbysean.
 */
@SpringBootApplication
@EnableDiscoveryClient
public class App {

    public static void main(String...args){
        SpringApplication.run(App.class);
    }
}
