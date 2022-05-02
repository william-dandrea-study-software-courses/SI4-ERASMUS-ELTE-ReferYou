package com.referyou.distributionservice.repository;

import com.referyou.distributionservice.entity.Rating;
import com.referyou.distributionservice.entity.RatingId;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RatingRepository extends CrudRepository<Rating, RatingId> {
}
