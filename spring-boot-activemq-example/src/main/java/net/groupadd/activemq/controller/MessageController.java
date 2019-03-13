package net.groupadd.activemq.controller;

import net.groupadd.activemq.model.SimpleMessage;
import net.groupadd.activemq.producer.QProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by itsbysean.
 */
@RestController
public class MessageController {


    @Autowired
    private QProducer qProducer;


    @PostMapping(path = "/msg")
    public ResponseEntity<?> put(@RequestBody final SimpleMessage simpleMessage){
        this.qProducer.produce(simpleMessage);
        return ResponseEntity.ok().build();
    }
}
