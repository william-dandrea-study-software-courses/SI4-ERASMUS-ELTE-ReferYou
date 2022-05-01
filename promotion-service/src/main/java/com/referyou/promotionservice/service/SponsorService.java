package com.referyou.promotionservice.service;



import com.referyou.promotionservice.entity.Sponsor;
import com.referyou.promotionservice.repository.SponsorRepository;
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
