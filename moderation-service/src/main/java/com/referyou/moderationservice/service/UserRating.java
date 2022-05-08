package com.referyou.moderationservice.service;

import lombok.Getter;

public class UserRating {
    @Getter()
    public final boolean isPositive;

    @Getter()
    public final boolean isNegative;

    public UserRating(boolean isPositive, boolean isNegative) {
        this.isPositive = isPositive;
        this.isNegative = isNegative;
    }
}
