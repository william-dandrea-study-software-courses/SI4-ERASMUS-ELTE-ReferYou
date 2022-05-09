package com.referyou.databasemodels.repository;

import com.referyou.databasemodels.entity.Website;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WebsiteRepository extends CrudRepository<Website, Long> {
}
