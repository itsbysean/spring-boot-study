package net.groupadd.activemq.producer;

import lombok.extern.slf4j.Slf4j;
import net.groupadd.activemq.model.SimpleMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * Created by itsbysean.
 */
@Slf4j
@Component
public class QProducer {

    @Value("${example.queue}")
    private String destination;

    @Autowired
    private JmsTemplate jmsTemplate;

    public void produce(final SimpleMessage simpleMessage){
        simpleMessage.setCreatedAt(LocalDateTime.now());
        this.jmsTemplate.convertAndSend(destination,simpleMessage);
        log.info("Message sent : " + simpleMessage.toString());
    }
}
