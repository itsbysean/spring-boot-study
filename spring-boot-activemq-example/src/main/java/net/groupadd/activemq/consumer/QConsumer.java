package net.groupadd.activemq.consumer;

import lombok.extern.slf4j.Slf4j;
import net.groupadd.activemq.model.SimpleMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import java.util.concurrent.CountDownLatch;

/**
 * Created by itsbysean.
 */
@Slf4j
@Component
public class QConsumer {

    @Autowired
    private CountDownLatch countDownLatch;

    public CountDownLatch getLatch() {
        return countDownLatch;
    }

    @JmsListener(destination = "${example.queue}", containerFactory = "listenerContainerFactory")
    public void receive(final SimpleMessage simpleMessage){
      log.info(simpleMessage.toString());
    }
}
