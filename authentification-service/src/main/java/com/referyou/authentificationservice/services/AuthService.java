package com.referyou.authentificationservice.services;



import com.referyou.authentificationservice.entity.Person;
import com.referyou.authentificationservice.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Optional;

/**
 * @author D'Andréa William
 */

@Service
public class AuthService {

    private final UserRepository userRepository;

    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public Optional<Person> createNewUser(String mail, String password) {
        // Variables
        long idNewUser = this.userRepository.count();
        Person person = new Person(mail, password);

        // Save in the database
        this.userRepository.save(person);

        return this.login(mail, password);
    }


    /**
     * Watch if a user is in the DB and logged it
     * @param mail of the user
     * @param password of the user
     * @return Optional empty if the user not exist, or the person if this person exist
     */
    public Optional<Person> login(String mail, String password) {
        // Get the user from the DB
        Optional<Person> personOp = this.userRepository.getUser(mail, password).stream().findFirst();

        // If the user exist, we update the token and return the person
        if (personOp.isPresent()) {
            Person person = personOp.get();

            person.generateNewToken();
            this.userRepository.save(person);
            return Optional.of(person);
        } else {
            return Optional.empty();
        }
    }

    public boolean watchIfIsLogged(String token) {
        Optional<Person> personOp = this.userRepository.getUserByToken(token).stream().findFirst();
        return personOp.isPresent();
    }

    public Person getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found."));
    }

}
