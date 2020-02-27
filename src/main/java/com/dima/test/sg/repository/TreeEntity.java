package com.dima.test.sg.repository;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tree", indexes = {
    @Index(name = "idx_tree_name", columnList = "name")
})
public class TreeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String name;

    @OneToMany(fetch = FetchType.LAZY)
    private List<TreeEntity> childList;

    public TreeEntity() {

    }

    public TreeEntity(final String name) {
        this.name = name;
    }

    public TreeEntity(final String name, final List<TreeEntity> childList) {
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

    public List<TreeEntity> getChildList() {
        return childList;
    }
}
