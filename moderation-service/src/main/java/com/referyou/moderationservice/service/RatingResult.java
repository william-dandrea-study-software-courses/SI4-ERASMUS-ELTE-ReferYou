package com.referyou.moderationservice.service;

import lombok.Getter;

public class RatingResult {
    @Getter
    private final int numberPositives;

    @Getter
    private final int numberNegatives;

    public RatingResult(int numberPositives, int numberNegatives) {
        this.numberPositives = numberPositives;
        this.numberNegatives = numberNegatives;
    }
}
