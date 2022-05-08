package com.referyou.moderationservice.repository;

import com.referyou.moderationservice.entity.Rating;
import com.referyou.moderationservice.entity.RatingId;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RatingRepository extends CrudRepository<Rating, RatingId> {

    @Query("SELECT count(r.codeId) FROM Rating r WHERE r.codeId = :codeId GROUP BY r.codeId")
    List<Integer> countDislikes(@Param("codeId") long codeId);
}
