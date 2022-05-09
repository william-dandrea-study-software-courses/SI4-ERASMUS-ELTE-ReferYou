package com.referyou.databasemodels.repository;

import com.referyou.databasemodels.entity.Code;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CodeRepository extends CrudRepository<Code, Long> {
}
