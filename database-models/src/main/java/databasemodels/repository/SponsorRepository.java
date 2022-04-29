package databasemodels.repository;

import databasemodels.entity.Sponsor;
import databasemodels.entity.SponsorId;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SponsorRepository extends CrudRepository<Sponsor, SponsorId> {
}
