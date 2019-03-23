package net.groupadd.es.repository;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.util.Date;
import java.util.UUID;

/**
 * Created by itsbysean.
 */
@Data
@Document(indexName = "simple-index", type = "simple-document")
public class SimpleDocument {

    @Id
    private UUID id;
    private String title;
    private String content;
    private Date createdAt;

    public SimpleDocument() {
        this.id = UUID.randomUUID();
        this.createdAt = new Date();
    }
}
