package net.groupadd.es.service;

import net.groupadd.es.repository.SimpleDocument;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;
import java.util.UUID;

/**
 * Created by itsbysean.
 */
public interface SimpleDocumentService {
    SimpleDocument save(SimpleDocument document);
    Page<SimpleDocument> findAll(Pageable pageable);
    Optional<SimpleDocument> findById(UUID id);
}
