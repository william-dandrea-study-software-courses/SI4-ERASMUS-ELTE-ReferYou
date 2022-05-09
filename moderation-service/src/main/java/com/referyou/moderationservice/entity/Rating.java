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
@IdClass(RatingId.class)
public class Rating {
    @Column(name = "user_id")
    @Id @Getter
    @JsonProperty("user_id")
    private long userId;

    @Column(name = "code_id")
    @Id @Getter
    @JsonProperty("code_id")
    private long codeId;


    @Getter
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", insertable = false, updatable = false)
    @JsonIgnore
    private Person user;

    @Getter
    @ManyToOne
    @JoinColumn(name = "code_id", referencedColumnName = "id", insertable = false, updatable = false)
    @JsonIgnore
    private Code code;

//    @Id @Getter
//    private long id;


    @Getter @Setter
    @JsonProperty("is_positive")
    private boolean isPositive;

    @Getter @Setter
    @JsonProperty("is_negative")
    private boolean isNegative;

    public Rating(long userId, long codeId, boolean positive, boolean negative) {
        this.userId = userId;
        this.codeId = codeId;
        this.isPositive = positive;
        this.isNegative = negative;
    }
}
