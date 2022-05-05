package com.referyou.authentificationservice.entity;

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
public class Sponsor {
    @Getter
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

    @OneToOne
    @Getter
    @JoinColumn(name = "code_id", referencedColumnName = "id", insertable = false, updatable = false)
    @JsonIgnore
    private Code code;


    @Getter @Setter
    @JsonProperty("amount")
    private float amount;

    public Sponsor(long userId, long codeId, float amount) {
        this.userId = userId;
        this.codeId = codeId;
        this.amount = amount;
    }
}
