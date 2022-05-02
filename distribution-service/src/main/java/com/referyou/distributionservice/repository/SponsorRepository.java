package com.referyou.distributionservice.repository;

import com.referyou.promotionservice.entity.Sponsor;
import com.referyou.promotionservice.entity.SponsorId;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SponsorRepository extends CrudRepository<Sponsor, SponsorId> {
}
