package com.referyou.promotionservice.repository;

import com.referyou.promotionservice.entity.Sponsor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SponsorRepository extends CrudRepository<Sponsor, Long> {
    @Modifying
    @Query("UPDATE Sponsor s SET s.amount = s.amount + :amount WHERE s.codeId = :codeId")
    List<Sponsor> promote(@Param("codeId") long codeId, @Param("amount") float amount);
}
