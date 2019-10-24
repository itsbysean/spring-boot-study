package net.groupadd.microservice;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by itsbysean.
 */
@RestController
@RequiredArgsConstructor
public class GreetingController {

    private final Greeting greeting;

    @GetMapping(value = "/greeting")
    public ResponseEntity<?> hello(){
        return ResponseEntity.ok(new GreetingDto(greeting.getMessage()));
    }

    @Getter
    @AllArgsConstructor
    private static class GreetingDto {
        private String message;
    }
}
