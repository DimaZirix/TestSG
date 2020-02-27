package com.dima.test.sg.api;

import com.dima.test.sg.service.Document;
import com.dima.test.sg.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {

    private final DocumentService documentService;

    @Autowired
    public ApiController(final DocumentService documentService) {
        this.documentService = documentService;
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Document> get(@PathVariable final long id) {
        final Document document = documentService.get(id);

        if (document == null) {
            return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .build();
        }

        return ResponseEntity.ok()
            .contentType(MediaType.APPLICATION_JSON)
            .body(document);
    }

    @GetMapping("/post/")
    public ResponseEntity<Long> post(@RequestParam final String name) {
        final Long id = documentService.create(name);

        if (id == null) {
            return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .build();
        }

        return ResponseEntity.ok()
            .contentType(MediaType.APPLICATION_JSON)
            .body(id);
    }

    @GetMapping("/put/")
    public ResponseEntity<Long> put(@RequestParam final String parent, @RequestParam final String child) {
        documentService.addChild(parent, child);

        return ResponseEntity.ok()
            .contentType(MediaType.APPLICATION_JSON)
            .build();
    }
}
