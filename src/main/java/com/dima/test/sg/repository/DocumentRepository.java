package com.dima.test.sg.repository;

import org.springframework.data.repository.CrudRepository;

public interface DocumentRepository extends CrudRepository<DocumentEntity, Long> {

    DocumentEntity findOneByName(String name);

}
