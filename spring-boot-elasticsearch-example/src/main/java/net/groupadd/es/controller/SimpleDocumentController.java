package net.groupadd.es.controller;

import net.groupadd.es.repository.SimpleDocument;
import net.groupadd.es.service.SimpleDocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by itsbysean.
 */
@RestController
@RequestMapping("/simple-document")
public class SimpleDocumentController {

    @Autowired
    private SimpleDocumentService simpleDocumentService;

    @PostMapping
    public ResponseEntity<?> save(@RequestBody final SimpleDocument document){
        return ResponseEntity.ok(this.simpleDocumentService.save(document));
    }

    @GetMapping
    public ResponseEntity<?> findAll(@PageableDefault final  Pageable pageable){
        return ResponseEntity.ok(this.simpleDocumentService.findAll(pageable));
    }
}
