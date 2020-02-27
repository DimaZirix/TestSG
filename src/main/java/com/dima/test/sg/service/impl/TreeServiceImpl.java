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

}
