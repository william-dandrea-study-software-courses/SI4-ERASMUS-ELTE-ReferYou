package com.referyou.databasemodels.repository;

import com.referyou.databasemodels.entity.Sponsor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SponsorRepository extends CrudRepository<Sponsor, Long> {
}
