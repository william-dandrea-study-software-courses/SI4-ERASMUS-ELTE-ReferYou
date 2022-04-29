package com.referyou.promotionservice.controllers;

import com.referyou.promotionservice.service.SponsorService;
import databasemodels.entity.Sponsor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SponsorController {

    private final SponsorService sponsorService;

    public SponsorController(SponsorService sponsorService) {
        this.sponsorService = sponsorService;
    }

    @PostMapping("/sponsor")
    public void CreateSponsor(Sponsor sponsor) {
        sponsorService.CreateSponsor(sponsor);
    }
}
