package com.referyou.authentificationservice.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;
import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Person {

    @Id
    @Getter
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Getter @Setter
    private String mail;

    @Getter @Setter
    private String password;

    @Getter @Setter
    private Boolean isBan;

    @Getter @Setter
    private String token;

    public Person(String mail, String password) {
        this.mail = mail;
        this.password = password;
        this.isBan = false;

        this.generateNewToken();
    }

    public void generateNewToken() {
        this.token = String.valueOf(UUID.randomUUID());
    }


    @Getter
    @JsonIgnore
    @OneToMany(targetEntity = Code.class, mappedBy = "ownerId", cascade = CascadeType.REMOVE)
    public List<Code> codes;
}
