package net.groupadd.es.base;

import org.testcontainers.elasticsearch.ElasticsearchContainer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by itsbysean.
 */
public abstract class AbstractElasticSearchBaseTest {

    /**
     *     image: docker.elastic.co/elasticsearch/elasticsearch:5.6.0
     *     environment:
     *       - cluster.name=docker-cluster
     *       - bootstrap.memory_lock=true
     *       - "ES_JAVA_OPTS=-Xms512m -Xmx512m"
     *       - xpack.security.enabled=false
     *       - node.data=true
     *       - network.publish_host=127.0.0.1
     *       - network.host=0.0.0.0
     *       - discovery.zen.minimum_master_nodes=1
     *     ulimits:
     *       memlock:
     *         soft: -1
     *         hard: -1
     *     ports:
     *       - "9200:9200"
     *       - "9300:9300"
     *     expose:
     *       - "9200"
     *       - "9300"
     */
    static final ElasticsearchContainer ELASTICSEARCH_CONTAINER;

    static {
        ELASTICSEARCH_CONTAINER = new ElasticsearchContainer("docker.elastic.co/elasticsearch/elasticsearch:5.6.0");
        ELASTICSEARCH_CONTAINER.withEnv(env());
        ELASTICSEARCH_CONTAINER.setPortBindings(portBindings());
        ELASTICSEARCH_CONTAINER.withExposedPorts(9300);
        ELASTICSEARCH_CONTAINER.start();
    }

    private static List<String> portBindings() {
        final List<String> portBinding = new ArrayList<>();
        portBinding.add("9200:9200");
        portBinding.add("9300:9300");
        return portBinding;
    }

    private static Map<String, String> env() {
        final Map<String, String> env = new HashMap<>();
        env.put("cluster.name", "docker-cluster");
        env.put("bootstrap.memory_lock", "true");
        env.put("ES_JAVA_OPTS", "-Xms512m -Xmx512m");
        env.put("xpack.security.enabled", "false");
        env.put("node.data", "true");
        env.put("network.publish_host", "127.0.0.1");
        env.put("network.host", "0.0.0.0");
        env.put("discovery.zen.minimum_master_nodes", "1");
        return env;
    }

    protected static void stop(){
        ELASTICSEARCH_CONTAINER.stop();
    }
}
