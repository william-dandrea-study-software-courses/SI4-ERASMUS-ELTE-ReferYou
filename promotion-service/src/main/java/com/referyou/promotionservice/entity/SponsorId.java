package com.referyou.promotionservice.entity;

import lombok.AllArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
public class SponsorId implements Serializable {
    private User user;
    private Code code;
}
