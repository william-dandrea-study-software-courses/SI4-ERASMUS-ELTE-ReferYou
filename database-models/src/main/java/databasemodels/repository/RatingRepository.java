package databasemodels.repository;

import databasemodels.entity.Rating;
import databasemodels.entity.RatingId;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RatingRepository extends CrudRepository<Rating, RatingId> {
}
