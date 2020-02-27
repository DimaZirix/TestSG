package com.dima.test.sg.service.impl;

import com.dima.test.sg.repository.DocumentEntity;
import com.dima.test.sg.repository.DocumentRepository;
import com.dima.test.sg.service.Document;
import com.dima.test.sg.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DocumentServiceImpl implements DocumentService {

    private final DocumentRepository documentRepository;

    @Autowired
    public DocumentServiceImpl(final DocumentRepository documentRepository) {
        this.documentRepository = documentRepository;
    }

    @Override
    @Transactional
    public Long getId(final String name) {
        final DocumentEntity entity = documentRepository.findOneByName(name);
        if (entity == null) {
            return null;
        }

        return entity.getId();
    }

    @Override
    @Transactional
    public Long create(final String name) {
        DocumentEntity entity = documentRepository.findOneByName(name);
        if (entity != null) {
            return null;
        }

        entity = new DocumentEntity(name);
        documentRepository.save(entity);

        return entity.getId();
    }

    @Override
    @Transactional
    public void addChild(final String parentName, final String childName) {
        final DocumentEntity parentEntity = getOrCreate(parentName);
        final DocumentEntity childEntity = getOrCreate(childName);

        parentEntity.getChildList().add(childEntity);
        documentRepository.save(parentEntity);
    }

    @Override
    @Transactional(readOnly = true)
    public Document get(final long id) {
        final DocumentEntity entity = documentRepository.findById(id).orElse(null);
        if (entity == null) {
            return null;
        }

        return entityToTreeMapper(entity, new HashMap<>());
    }

    private Document entityToTreeMapper(final DocumentEntity entity, final Map<Long, Document> treeMap) {
        final Document mappedDocument = treeMap.get(entity.getId());
        if (mappedDocument != null) {
            return mappedDocument;
        }

        final Document document = new Document(entity.getId(), entity.getName());
        treeMap.put(document.getId(), document);

        final List<Document> childList = entity.getChildList().stream()
            .map(p -> entityToTreeMapper(p, treeMap))
            .collect(Collectors.toList());

        document.getChildList().addAll(childList);

        return document;
    }

    private DocumentEntity getOrCreate(final String name) {
        DocumentEntity entity = documentRepository.findOneByName(name);
        if (entity != null) {
            return entity;
        }

        entity = new DocumentEntity(name);
        documentRepository.save(entity);

        return entity;
    }
}
