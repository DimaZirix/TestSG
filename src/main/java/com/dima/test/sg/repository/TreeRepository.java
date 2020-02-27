package com.dima.test.sg.repository;

import org.springframework.data.repository.CrudRepository;

public interface TreeRepository extends CrudRepository<TreeEntity, Long> {

    TreeEntity findOneByName(String name);

}
