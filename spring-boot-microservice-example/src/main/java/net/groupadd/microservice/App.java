package net.groupadd.microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by itsbysean.
 */
@RestController
@SpringBootApplication
@EnableDiscoveryClient
public class App {
    public static void main(String...args){
        SpringApplication.run(App.class);
    }

    @GetMapping(value = "/hello")
    public ResponseEntity<?> hello(){
        final Map<String,String> res = new HashMap<>();
        res.put("hello","world");
        return ResponseEntity.ok(res);
    }
}
