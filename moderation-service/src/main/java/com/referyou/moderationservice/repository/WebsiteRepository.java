package com.referyou.moderationservice.repository;

import com.referyou.moderationservice.entity.Website;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WebsiteRepository extends CrudRepository<Website, Long> {
}
