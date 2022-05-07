package com.referyou.authentificationservice.controllers;

import com.referyou.authentificationservice.entity.Person;
import com.referyou.authentificationservice.services.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

/**
 * @author D'Andréa William
 */

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }


    @GetMapping(path="", consumes = {"*/*"})
    public ResponseEntity<String> getAuthTest() {
        return ResponseEntity.ok("Auth Test Working 3");
    }


    /**
     * @param : body : {
     *     mail: "< USER-MAIL >",
     *     password: "< USER-PASSWORD >"
     * }
     * @return Person entity if this person exist or null if not
     */
    @PostMapping(path="/register", consumes = {"*/*"})
    public ResponseEntity<Person> createNewUser(@RequestBody Map<String, String> mailAndPassword) {
        String mail = mailAndPassword.get("mail");
        String password = mailAndPassword.get("password");

        Optional<Person> personOptional = this.authService.createNewUser(mail, password);

        return personOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.ok(null));
    }

    /**
     * @param : body : {
     *     mail: "< USER-MAIL >",
     *     password: "< USER-PASSWORD >"
     * }
     * @return Person entity if this person exist or null if not
     */
    @PostMapping(path="/login", consumes = {"*/*"})
    public ResponseEntity<Person> login(@RequestBody Map<String, String> mailAndPassword) {
        String mail = mailAndPassword.get("mail");
        String password = mailAndPassword.get("password");

        Optional<Person> personOptional = this.authService.login(mail, password);

        return personOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.ok(null));
    }

    @GetMapping(path="/user/id", consumes = {"*/*"})
    public ResponseEntity.BodyBuilder getUserById() {
        return ResponseEntity.status(404);
    }

    @DeleteMapping(path="/user/id", consumes = {"*/*"})
    public ResponseEntity.BodyBuilder deleteUserById() {
        return ResponseEntity.status(404);
    }

    @PutMapping(path="/user/id", consumes = {"*/*"})
    public ResponseEntity.BodyBuilder updateUserById() {
        return ResponseEntity.status(404);
    }








}
