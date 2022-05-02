package com.referyou.moderationservice.repository;

import com.referyou.moderationservice.entity.Sponsor;
import com.referyou.moderationservice.entity.SponsorId;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SponsorRepository extends CrudRepository<Sponsor, SponsorId> {
}
