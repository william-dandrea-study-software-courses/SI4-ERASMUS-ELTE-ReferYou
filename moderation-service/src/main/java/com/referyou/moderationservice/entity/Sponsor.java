package com.referyou.moderationservice.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@IdClass(SponsorId.class)
public class Sponsor {
    @Id @Getter
    @Column(name = "user_id")
    @JsonProperty("user_id")
    private long userId;

    @Id @Getter
    @Column(name = "code_id")
    @JsonProperty("code_id")
    private long codeId;

    @ManyToOne
    @Getter
    @JoinColumn(name = "user_id", referencedColumnName = "id", insertable = false, updatable = false)
    @JsonIgnore
    private Person user;

    @ManyToOne
    @Getter
    @JoinColumn(name = "code_id", referencedColumnName = "id", insertable = false, updatable = false)
    @JsonIgnore
    private Code code;


    @Getter @Setter
    @JsonProperty("amount")
    private float amount;
}
