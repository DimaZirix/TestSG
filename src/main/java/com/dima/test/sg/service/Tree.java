package com.dima.test.sg.service;

import java.util.ArrayList;
import java.util.List;

public final class Tree {

    private final long id;

    private final String name;

    private final List<Tree> childList;

    public Tree(final long id, final String name) {
        this.id = id;
        this.name = name;
        this.childList = new ArrayList<>();
    }

    public Tree(final long id, final String name, final List<Tree> childList) {
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

    public List<Tree> getChildList() {
        return childList;
    }

    @Override
    public String toString() {
        return id + "=" + name + "{" + childList + "}";
    }
}
