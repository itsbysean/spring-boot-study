package net.groupadd.microservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by itsbysean.
 */
@RestController
public class GreetingController {

    @Autowired
    private Greeting greeting;

    @GetMapping(value = "/hello")
    public ResponseEntity<?> hello(){
        return ResponseEntity.ok(greeting);
    }
}
