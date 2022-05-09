package com.referyou.promotionservice.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

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
