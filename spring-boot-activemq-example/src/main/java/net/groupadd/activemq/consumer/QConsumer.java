package net.groupadd.activemq.consumer;

import lombok.extern.slf4j.Slf4j;
import net.groupadd.activemq.model.SimpleMessage;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import java.util.concurrent.CountDownLatch;

/**
 * Created by itsbysean.
 */
@Slf4j
@Component
public class QConsumer {

    private CountDownLatch countDownLatch = new CountDownLatch(1);

    public CountDownLatch getLatch() {
        return this.countDownLatch;
    }

    @JmsListener(destination = "${example.queue}", containerFactory = "simpleQueueFactory")
    public void receive(final SimpleMessage simpleMessage){
        log.info(simpleMessage.toString());
        getLatch().countDown();
    }
}
