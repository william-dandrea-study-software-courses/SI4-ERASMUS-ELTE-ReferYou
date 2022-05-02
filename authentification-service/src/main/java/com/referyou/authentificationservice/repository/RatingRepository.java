package com.referyou.authentificationservice.repository;

import com.referyou.authentificationservice.entity.Rating;
import com.referyou.authentificationservice.entity.RatingId;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RatingRepository extends CrudRepository<Rating, RatingId> {
}
