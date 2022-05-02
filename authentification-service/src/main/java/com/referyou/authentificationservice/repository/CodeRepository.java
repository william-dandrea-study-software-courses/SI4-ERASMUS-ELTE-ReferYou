package com.referyou.authentificationservice.repository;

import com.referyou.promotionservice.entity.Code;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CodeRepository extends CrudRepository<Code, Long> {
}
