package com.referyou.distributionservice.repository;

import com.referyou.distributionservice.entity.Sponsor;
import com.referyou.distributionservice.entity.SponsorId;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SponsorRepository extends CrudRepository<Sponsor, SponsorId> {
}
