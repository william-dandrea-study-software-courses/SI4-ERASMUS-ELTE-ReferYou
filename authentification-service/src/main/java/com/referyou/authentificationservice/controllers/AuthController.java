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


    @CrossOrigin(origins = "*")
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
    @CrossOrigin(origins = "*")
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
    @CrossOrigin(origins = "*")
    @PostMapping(path="/login", consumes = {"*/*"})
    public ResponseEntity<Person> login(@RequestBody Map<String, String> mailAndPassword) {
        String mail = mailAndPassword.get("mail");
        String password = mailAndPassword.get("password");

        Optional<Person> personOptional = this.authService.login(mail, password);

        return personOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.ok(null));
    }

    @CrossOrigin(origins = "*")
    @GetMapping(path="/connected", consumes = {"*/*"})
    public ResponseEntity<Boolean> watchIfIsLogged(@RequestBody Map<String, String> tokensMap) {
        String token = tokensMap.get("token");
        return ResponseEntity.ok(this.authService.watchIfIsLogged(token));
    }

    @CrossOrigin(origins = "*")
    @GetMapping(path="/user/id", consumes = {"*/*"})
    public ResponseEntity<Person> getUserById(Map<String, Long> idMap) {
        Long id = idMap.get("id");
        Optional<Person> person = this.authService.getUserById(id);
        return person.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.ok(null));
    }



    /** USLESS in our case
    @PutMapping(path="/user/id", consumes = {"* / *"})
    public ResponseEntity.BodyBuilder updateUserById() {
        return ResponseEntity.status(404);
    }
    **/







}
