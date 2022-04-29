package com.referyou.promotionservice.controllers;

import com.referyou.promotionservice.entity.Sponsor;
import org.apache.commons.lang.NotImplementedException;
import org.springframework.web.bind.annotation.*;

@RestController("/promotion")
public class SponsorController {

    @PostMapping("/")
    public Sponsor CreatePromotion(Float value) {
        throw new NotImplementedException();
    }

    @GetMapping("/{id}")
    public Sponsor GetPromotionById(@PathVariable Long id) {
        throw new NotImplementedException();
    }

    @GetMapping("/")
    public Sponsor GetPromotionByCodeId(@RequestParam("codeId") Long codeId) {
        throw new NotImplementedException();
    }

    @DeleteMapping("/")
    public Sponsor DeletePromotionsByCodeId(@RequestParam("codeId") Long codeId) {
        throw new NotImplementedException();
    }

    @GetMapping("/value")
    public Float GetPromotionValueByCodeId(@RequestParam("codeId") Long codeId) {
        throw new NotImplementedException();
    }
}
