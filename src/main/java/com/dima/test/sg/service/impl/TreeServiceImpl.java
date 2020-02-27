package com.dima.test.sg.service.impl;

import com.dima.test.sg.repository.TreeEntity;
import com.dima.test.sg.repository.TreeRepository;
import com.dima.test.sg.service.Tree;
import com.dima.test.sg.service.TreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class TreeServiceImpl implements TreeService {

    private final TreeRepository treeRepository;

    @Autowired
    public TreeServiceImpl(final TreeRepository treeRepository) {
        this.treeRepository = treeRepository;
    }



    @Transactional(readOnly = true)
    public Tree getTree(final long id) {
        final TreeEntity entity = treeRepository.findById(id).orElse(null);
        if (entity == null) {
            return null;
        }

        return entityToTreeMapper(entity, new HashMap<>());
    }

    private Tree entityToTreeMapper(final TreeEntity entity, final Map<Long, Tree> treeMap) {
        final Tree mappedTree = treeMap.get(entity.getId());
        if (mappedTree != null) {
            return mappedTree;
        }

        final Tree tree = new Tree(entity.getId(), entity.getName());
        treeMap.put(tree.getId(), tree);

        final List<Tree> childList = entity.getChildList().stream()
            .map(p -> entityToTreeMapper(p, treeMap))
            .collect(Collectors.toList());

        tree.getChildList().addAll(childList);

        return tree;
    }
}
