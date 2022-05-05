package com.referyou.promotionservice.service;



import com.referyou.promotionservice.entity.Sponsor;
import com.referyou.promotionservice.repository.CodeRepository;
import com.referyou.promotionservice.repository.SponsorRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class SponsorService {

    private final SponsorRepository sponsorRepository;
    private final CodeRepository codeRepository;

    public SponsorService(SponsorRepository sponsorRepository, CodeRepository codeRepository) {
        this.sponsorRepository = sponsorRepository;
        this.codeRepository = codeRepository;
    }

    public float getAmount(long codeId) {
        var code = codeRepository.findById(codeId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Code not found"));
        if(code.sponsor == null)
            return 0;
        else
            return code.sponsor.getAmount();
    }

    /**
     * @param codeId Id of the code to promote
     * @param amount The amount of the promotion
     * @return The current value of the code (the sum of all the promotions)
     */
    public float promote(long codeId, float amount) {
        // Retrieve eventual sponsor action
        var promotion = sponsorRepository.findById(codeId);

        if(promotion.isPresent()) {
            // if this code has already been sponsorized
            // increament the amount of the promotion
            var newAmount = promotion.get().getAmount() + amount;
            promotion.get().setAmount(newAmount);
            sponsorRepository.save(promotion.get());
            return newAmount;
        } else {
            // otherwise, create a new one
            var ownerId = codeRepository.findById(codeId)
                            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Code not found"))
                            .getOwnerId();
            sponsorRepository.save(new Sponsor(ownerId, codeId, amount));
            return amount;
        }
    }
}
