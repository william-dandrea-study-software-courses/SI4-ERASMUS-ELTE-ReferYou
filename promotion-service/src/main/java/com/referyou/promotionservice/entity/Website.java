package com.referyou.promotionservice.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Website {

    @Id @Getter @Setter
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

    @Getter
    @JsonIgnore
    @OneToMany(mappedBy = "websiteId", targetEntity = Code.class, cascade = CascadeType.REMOVE)
    private List<Code> codes;
}
