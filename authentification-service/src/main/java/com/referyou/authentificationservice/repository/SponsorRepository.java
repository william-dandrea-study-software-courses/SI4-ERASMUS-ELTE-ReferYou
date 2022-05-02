package com.referyou.authentificationservice.repository;

import com.referyou.authentificationservice.entity.Sponsor;
import com.referyou.authentificationservice.entity.SponsorId;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SponsorRepository extends CrudRepository<Sponsor, SponsorId> {
}
