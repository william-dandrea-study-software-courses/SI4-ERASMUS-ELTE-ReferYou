package com.referyou.distributionservice.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    @Id
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

    @Getter
    @JsonIgnore
    @OneToMany(targetEntity = Code.class, mappedBy = "ownerId", cascade = CascadeType.REMOVE)
    public List<Code> codes;
}
