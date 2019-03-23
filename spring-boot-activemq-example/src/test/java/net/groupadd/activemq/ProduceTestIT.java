package net.groupadd.activemq;

import lombok.extern.slf4j.Slf4j;
import net.groupadd.activemq.consumer.QConsumer;
import net.groupadd.activemq.model.SimpleMessage;
import net.groupadd.activemq.producer.QProducer;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * Created by itsbysean.
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class ProduceTestIT {

    private final static String MESSAGE = "Hello World";

    @Autowired
    private QProducer qProducer;

    @Autowired
    private QConsumer qConsumer;


    private UUID id;

    @Before
    public void init(){
        this.id = UUID.randomUUID();
    }

    @Test
    public void test_produce_and_consume_simple_message() throws InterruptedException {
        final SimpleMessage message = new SimpleMessage();
        message.setId(this.id);
        message.setMsg(MESSAGE);
        this.qProducer.produce(message);
        this.qConsumer.getLatch().await(10, TimeUnit.SECONDS);
        final long count = this.qConsumer.getLatch().getCount();
        log.info("count is : "+ count);
        Assert.assertEquals(0,count);

    }


}
