package com.referyou.promotionservice.controllers;

import com.referyou.promotionservice.service.SponsorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/promotion")
public class SponsorController {

    private final SponsorService sponsorService;

    public SponsorController(SponsorService sponsorService) {
        this.sponsorService = sponsorService;
    }

    @GetMapping("")
    public ResponseEntity<String> getTest() {
        return ResponseEntity.ok("Test");
    }

    /**
     * @param codeId The id of the code
     * @return the sum of all the previous promotions
     */
    @GetMapping("{codeId}")
    public float getAmountForCode(@PathVariable() long codeId) {
        return sponsorService.getAmount(codeId);
    }

    public static class PromoteRequest {
        public float amount;
    }
    @PostMapping("{codeId}")
    public float promote(@PathVariable() long codeId, @RequestBody() PromoteRequest body) {
        return sponsorService.promote(codeId, body.amount);
    }


}
