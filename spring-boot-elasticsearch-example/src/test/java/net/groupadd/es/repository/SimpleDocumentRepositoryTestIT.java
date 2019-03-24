package net.groupadd.es.repository;

import lombok.extern.slf4j.Slf4j;
import net.groupadd.es.base.AbstractElasticSearchBaseTest;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.Optional;
import java.util.UUID;

/**
 * Created by itsbysean.
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class SimpleDocumentRepositoryTestIT extends AbstractElasticSearchBaseTest {

    @Autowired
    private SimpleDocumentRepository simpleDocumentRepository;

    private SimpleDocument document;

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

        Assert.assertTrue(optionalFoundDocument.isPresent());

        final SimpleDocument simpleDocument = optionalFoundDocument.get();
        Assert.assertEquals("same id", simpleDocument.getId(), this.document.getId());
    }

    @AfterClass
    public static void tearDownOnce() throws Exception {
        stop();
    }
}
