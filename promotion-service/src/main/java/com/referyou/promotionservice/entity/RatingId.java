package com.referyou.promotionservice.entity;

import lombok.AllArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
public class RatingId implements Serializable {
    private long userID;
    private long codeID;
}
