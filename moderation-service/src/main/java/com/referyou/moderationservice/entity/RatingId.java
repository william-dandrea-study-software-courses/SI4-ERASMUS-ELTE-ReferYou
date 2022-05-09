package com.referyou.moderationservice.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
public class RatingId implements Serializable {
    private long userId;
    private long codeId;
}
