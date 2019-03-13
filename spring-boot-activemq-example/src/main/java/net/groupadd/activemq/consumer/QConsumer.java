package net.groupadd.activemq.consumer;

import lombok.extern.slf4j.Slf4j;
import net.groupadd.activemq.model.SimpleMessage;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * Created by itsbysean.
 */
@Slf4j
@Component
public class QConsumer {

    @JmsListener(destination = "${example.queue}", containerFactory = "simpleQueueFactory")
    public void receive(final SimpleMessage simpleMessage){
      log.info(simpleMessage.toString());
    }
}
