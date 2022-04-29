package com.referyou.promotionservice.entity;

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

    @ManyToOne
    @Id @Getter
    private User user;

    @ManyToOne
    @Id @Getter
    private Code code;


    @Getter @Setter
    private float eurAmount;
}
