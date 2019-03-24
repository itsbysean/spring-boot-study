package net.groupadd.activemq.base;

import org.testcontainers.containers.GenericContainer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by itsbysean.
 */
public abstract class AbstractActiveMQBaseTest {

    /**
     *   image: rmohr/activemq:5.15.4"
     *   ports:
     *     - 8161:8161
     *     - 61616:61616
     *     - 61613:61613
     */
    final static GenericContainer ACTIVEMQ_CONTAINER;

    static {
        ACTIVEMQ_CONTAINER = new GenericContainer<>("rmohr/activemq:5.15.4");
        ACTIVEMQ_CONTAINER.setPortBindings(portBindings());
        ACTIVEMQ_CONTAINER.withExposedPorts(61616);
        ACTIVEMQ_CONTAINER.start();
    }

    private static List<String> portBindings() {
        final List<String> portBinding = new ArrayList<>();
        portBinding.add("61616:61616");
        return portBinding;
    }

    protected static void stop(){
        ACTIVEMQ_CONTAINER.stop();
    }
}
