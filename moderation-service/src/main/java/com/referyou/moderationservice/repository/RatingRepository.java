package com.referyou.moderationservice.repository;

import com.referyou.moderationservice.entity.Rating;
import com.referyou.moderationservice.entity.RatingId;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RatingRepository extends CrudRepository<Rating, RatingId> {
}
