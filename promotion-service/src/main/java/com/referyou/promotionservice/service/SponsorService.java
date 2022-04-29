package com.referyou.promotionservice.service;

import databasemodels.entity.Sponsor;
import databasemodels.repository.SponsorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SponsorService {

    private final SponsorRepository sponsorRepository;

    public SponsorService(SponsorRepository sponsorRepository) {
        this.sponsorRepository = sponsorRepository;
    }

    public void CreateSponsor(Sponsor sponsor) {
        sponsorRepository.save(sponsor);
    }
}
