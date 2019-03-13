package net.groupadd.activemq;

import net.groupadd.activemq.model.SimpleMessage;
import net.groupadd.activemq.producer.QProducer;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

/**
 * Created by itsbysean.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class ProduceTest {

    private final static String MESSAGE = "Hello World";

    @Value("${example.queue}")
    private String queue;

    @Autowired
    private QProducer qProducer;

    @Autowired
    private JmsTemplate jmsTemplate;


    private UUID id;

    @Before
    public void init(){
        this.id = UUID.randomUUID();
    }

    @Test
    public void test_produce_simple_message() throws InterruptedException {
        final SimpleMessage message = new SimpleMessage();
        message.setId(this.id);
        message.setMsg(MESSAGE);
        this.qProducer.produce(message);
        Thread.sleep(1000l);

        final SimpleMessage received = (SimpleMessage) this.jmsTemplate.receiveAndConvert(queue);

        Assert.assertEquals(received.getId().toString(), id.toString());

    }


}
