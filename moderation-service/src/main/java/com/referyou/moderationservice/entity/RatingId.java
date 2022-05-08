package com.referyou.moderationservice.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@NoArgsConstructor
public class RatingId implements Serializable {
    @Getter @Setter
    private long userId;

    @Getter @Setter
    private long codeId;


    public RatingId(long userId, long codeId) {
        this.userId = userId;
        this.codeId = codeId;
    }
}
