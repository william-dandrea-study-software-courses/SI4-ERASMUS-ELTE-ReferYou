package com.referyou.distributionservice.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Website {

    @Id @Getter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("website_id")
    private long id;

    @NotNull
    @Getter @Setter
    @JsonProperty("url")
    private String url;

    @Getter @Setter
    @JsonProperty("description")
    private String description;
}
