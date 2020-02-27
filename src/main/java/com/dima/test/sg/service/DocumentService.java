package com.dima.test.sg.service;

import org.springframework.transaction.annotation.Transactional;

public interface DocumentService {

    @Transactional
    Long getId(String name);

    @Transactional
    long add(String name);

    @Transactional
    long addChild(String parentName, String childName);

    @Transactional(readOnly = true)
    Document get(long id);
}
