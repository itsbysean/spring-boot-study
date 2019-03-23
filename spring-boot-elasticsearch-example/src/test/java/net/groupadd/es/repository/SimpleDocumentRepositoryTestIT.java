package net.groupadd.es.repository;

import lombok.extern.slf4j.Slf4j;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.testcontainers.elasticsearch.ElasticsearchContainer;

import java.util.*;

/**
 * Created by itsbysean.
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class SimpleDocumentRepositoryTestIT {

    private static ElasticsearchContainer container;

    @Autowired
    private SimpleDocumentRepository simpleDocumentRepository;

    private SimpleDocument document;

    @BeforeClass
    public static void setUpOnce() throws Exception {
        container = new ElasticsearchContainer("docker.elastic.co/elasticsearch/elasticsearch:5.6.0").withEnv(envMapBuilder());
        container.setPortBindings(portBinding());
        container.withExposedPorts(9200, 9300);
        container.start();
    }

    private static List<String> portBinding() {
        final List<String> portBinding = new ArrayList<>();
        portBinding.add("9200:9200");
        portBinding.add("9300:9300");
        return portBinding;
    }

    private static Map<String, String> envMapBuilder() {
        final Map<String, String> envAsMap = new HashMap<>();
        envAsMap.put("cluster.name", "docker-cluster");
        envAsMap.put("bootstrap.memory_lock", "true");
        envAsMap.put("ES_JAVA_OPTS", "-Xms512m -Xmx512m");
        envAsMap.put("xpack.security.enabled", "false");
        envAsMap.put("node.data", "true");
        envAsMap.put("network.publish_host", "127.0.0.1");
        envAsMap.put("network.host", "0.0.0.0");
        envAsMap.put("discovery.zen.minimum_master_nodes", "1");
        return envAsMap;
    }

    @Before
    public void setUp() throws Exception {
        final UUID id = UUID.randomUUID();
        this.document = new SimpleDocument();
        document.setId(id);
        document.setTitle("Hello World");
        document.setContent("This is just Simple content");
        document.setCreatedAt(new Date());
    }

    @Test
    public void test_save_document() {
        final SimpleDocument savedDocument = this.simpleDocumentRepository.save(document);
        Assert.assertEquals("same id", savedDocument.getId(), this.document.getId());
    }

    @Test
    public void test_get_document_by_id() {
        final SimpleDocument savedDocument = this.simpleDocumentRepository.save(this.document);
        final Optional<SimpleDocument> optionalFoundDocument = this.simpleDocumentRepository.findById(savedDocument.getId());
        if (optionalFoundDocument.isPresent()) {
            log.info(optionalFoundDocument.get().toString());
        }
    }

    @AfterClass
    public static void tearDownOnce() throws Exception {
        container.stop();
    }
}
