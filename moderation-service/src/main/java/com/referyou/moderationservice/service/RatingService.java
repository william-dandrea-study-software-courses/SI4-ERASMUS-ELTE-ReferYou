package com.referyou.moderationservice.service;

import com.referyou.moderationservice.entity.Rating;
import com.referyou.moderationservice.entity.RatingId;
import com.referyou.moderationservice.repository.CodeRepository;
import com.referyou.moderationservice.repository.RatingRepository;
import com.referyou.moderationservice.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class RatingService {

    private final RatingRepository ratingRepository;
    private final CodeRepository codeRepository;
    private final UserRepository userRepository;

    public RatingService(RatingRepository ratingRepository, CodeRepository codeRepository, UserRepository userRepository) {
        this.ratingRepository = ratingRepository;
        this.codeRepository = codeRepository;
        this.userRepository = userRepository;
    }

    public void dislike(long codeId, long userId) {
        if(!codeRepository.existsById(codeId))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Code not found");
        if(!userRepository.existsById(userId))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");

        var counts = ratingRepository.countDislikes(codeId);
        var numberOfDislikes = (counts.size() == 0 ? 0 : counts.stream().findFirst().get()) + 1;

        if(numberOfDislikes >= 10)
            codeRepository.deleteById(codeId);
        else
            ratingRepository.save(new Rating(userId, codeId, false, true));
    }

    public void like(long codeId, long userId) {
        if(!codeRepository.existsById(codeId))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Code not found");
        if(!userRepository.existsById(userId))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");

        ratingRepository.save(new Rating(userId, codeId, true, false));
    }

    public UserRating get(long codeId, long userId) {
        if(!codeRepository.existsById(codeId))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Code not found");
        if(!userRepository.existsById(userId))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");

        var res = ratingRepository.findById(new RatingId(userId, codeId));
        return res
                .map(rating -> new UserRating(rating.isPositive(), rating.isNegative()))
                .orElseGet(() -> new UserRating(false, false));
    }

    public RatingResult getState(long codeId) {
        if(!codeRepository.existsById(codeId))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Code not found");

        var ratings = codeRepository.findById(codeId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Code not found"))
                .ratings;

        return new RatingResult(
                (int)ratings.stream().filter(Rating::isPositive).count(),
                (int)ratings.stream().filter(Rating::isNegative).count()
        );
    }

    public void removeRating(long codeId, long userId) {
        if(!codeRepository.existsById(codeId))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Code not found");
        if(!userRepository.existsById(userId))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");

        ratingRepository.deleteById(new RatingId(userId, codeId));
    }

}
