package com.referyou.databasemodels.entity;

import lombok.AllArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
public class RatingId implements Serializable {
    private long userId;
    private long codeId;
}
