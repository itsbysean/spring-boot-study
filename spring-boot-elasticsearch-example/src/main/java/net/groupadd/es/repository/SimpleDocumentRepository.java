package net.groupadd.es.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.UUID;

/**
 * Created by itsbysean.
 */
public interface SimpleDocumentRepository extends ElasticsearchRepository<SimpleDocument, UUID> {
}
