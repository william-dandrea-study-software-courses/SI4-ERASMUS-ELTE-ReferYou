package com.referyou.databasemodels.repository;

import com.referyou.databasemodels.entity.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<Person, Long> {
}
