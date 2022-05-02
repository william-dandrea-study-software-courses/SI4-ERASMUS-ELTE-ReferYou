package com.referyou.distributionservice.repository;

import com.referyou.distributionservice.entity.Code;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CodeRepository extends CrudRepository<Code, Long> {
}
