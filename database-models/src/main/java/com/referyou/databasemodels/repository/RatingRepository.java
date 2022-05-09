package com.referyou.databasemodels.repository;

import com.referyou.databasemodels.entity.Rating;
import com.referyou.databasemodels.entity.RatingId;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RatingRepository extends CrudRepository<Rating, RatingId> {
}
