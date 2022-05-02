package com.referyou.distributionservice.repository;

import com.referyou.promotionservice.entity.Website;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WebsiteRepository extends CrudRepository<Website, Long> {
}
