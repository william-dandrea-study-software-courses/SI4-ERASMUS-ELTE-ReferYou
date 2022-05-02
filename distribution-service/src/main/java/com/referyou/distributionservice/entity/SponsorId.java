package com.referyou.distributionservice.entity;

import lombok.AllArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
public class SponsorId implements Serializable {
    private long userId;
    private long codeId;
}
