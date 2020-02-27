package com.dima.test.sg.service;

import org.springframework.transaction.annotation.Transactional;

public interface DocumentService {

    @Transactional
    Long getId(String name);

    @Transactional
    Long create(String name);

    @Transactional
    void addChild(String parentName, String childName);

    @Transactional(readOnly = true)
    Document get(long id);
}
