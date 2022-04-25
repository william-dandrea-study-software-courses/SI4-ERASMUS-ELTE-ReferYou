package com.referyou.promotionservice.controllers;

import com.referyou.promotionservice.models.Promotion;
import org.apache.commons.lang.NotImplementedException;
import org.springframework.web.bind.annotation.*;

@RestController("/promotion")
public class PromotionController {

    @PostMapping("/")
    public Promotion CreatePromotion(Float value) {
        throw new NotImplementedException();
    }

    @GetMapping("/{id}")
    public Promotion GetPromotionById(@PathVariable Long id) {
        throw new NotImplementedException();
    }

    @GetMapping("/")
    public Promotion GetPromotionByCodeId(@RequestParam("codeId") Long codeId) {
        throw new NotImplementedException();
    }

    @DeleteMapping("/")
    public Promotion DeletePromotionsByCodeId(@RequestParam("codeId") Long codeId) {
        throw new NotImplementedException();
    }

    @GetMapping("/value")
    public Float GetPromotionValueByCodeId(@RequestParam("codeId") Long codeId) {
        throw new NotImplementedException();
    }
}
