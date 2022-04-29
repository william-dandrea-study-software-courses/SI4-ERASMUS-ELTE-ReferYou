package com.referyou.promotionservice.entity;

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

    @Getter @Id
    @ManyToOne
    private User user;

    @Getter @Id
    @ManyToOne
    private Code code;


    @Getter @Setter
    private boolean isPositive;

    @Getter @Setter
    private boolean isNegative;
}
