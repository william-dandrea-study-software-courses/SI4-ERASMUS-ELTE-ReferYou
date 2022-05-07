package com.referyou.authentificationservice.repository;

import com.referyou.authentificationservice.entity.Person;
import com.referyou.authentificationservice.entity.Sponsor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<Person, Long> {



    @Query("SELECT p FROM Person p WHERE p.mail = :mail AND p.password = :password")
    List<Person> getUser(@Param("mail") String mail, @Param("password") String password);


    @Query("SELECT p FROM Person p WHERE p.token = :token")
    List<Person> getUserByToken(@Param("token") String token);


}
