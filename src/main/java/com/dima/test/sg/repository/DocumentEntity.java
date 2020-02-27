package com.dima.test.sg.repository;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "document", indexes = {
    @Index(name = "idx_document_name", columnList = "name")
})
public class DocumentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String name;

    @OneToMany(fetch = FetchType.LAZY)
    private List<DocumentEntity> childList;

    public DocumentEntity() {

    }

    public DocumentEntity(final String name) {
        this.name = name;
        this.childList = new ArrayList<>();
    }

    public DocumentEntity(final String name, final List<DocumentEntity> childList) {
        this.name = name;
        this.childList = childList;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public List<DocumentEntity> getChildList() {
        return childList;
    }
}
