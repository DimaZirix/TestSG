package com.dima.test.sg.service;

import java.util.ArrayList;
import java.util.List;

public final class Document {

    private final long id;

    private final String name;

    private final List<Document> childList;

    public Document(final long id, final String name) {
        this.id = id;
        this.name = name;
        this.childList = new ArrayList<>();
    }

    public Document(final long id, final String name, final List<Document> childList) {
        this.id = id;
        this.name = name;
        this.childList = childList;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Document> getChildList() {
        return childList;
    }

    @Override
    public String toString() {
        return id + "=" + name + "{" + childList + "}";
    }
}
