package net.groupadd.es.service;

import net.groupadd.es.repository.SimpleDocument;
import net.groupadd.es.repository.SimpleDocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

/**
 * Created by itsbysean.
 */
@Service
public class SimpleDocumentServiceImpl implements SimpleDocumentService {

    @Autowired
    private SimpleDocumentRepository simpleDocumentRepository;

    @Override
    public SimpleDocument save(SimpleDocument document) {
        return this.simpleDocumentRepository.save(document);
    }

    @Override
    public Page<SimpleDocument> findAll(Pageable pageable) {
        return this.simpleDocumentRepository.findAll(pageable);
    }

    @Override
    public Optional<SimpleDocument> findById(UUID id) {
        return this.simpleDocumentRepository.findById(id);
    }
}
