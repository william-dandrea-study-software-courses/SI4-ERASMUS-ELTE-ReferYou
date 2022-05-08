package com.referyou.moderationservice.controller;

import com.referyou.moderationservice.entity.Rating;
import com.referyou.moderationservice.service.RatingResult;
import com.referyou.moderationservice.service.RatingService;
import com.referyou.moderationservice.service.UserRating;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("moderation")
public class RatingController {

    private final RatingService ratingService;

    public RatingController(RatingService ratingService) {
        this.ratingService = ratingService;
    }

    @GetMapping("/code/{codeId}/user/{userId}")
    public UserRating get(@PathVariable long codeId, @PathVariable long userId) {
        return ratingService.get(codeId, userId);
    }

    @GetMapping("/code/{codeId}")
    public RatingResult getForCode(@PathVariable long codeId) {
        return ratingService.getState(codeId);
    }

    @PostMapping("/code/{codeId}/user/{userId}/dislike")
    public void dislike(@PathVariable long codeId, @PathVariable long userId) {
        ratingService.dislike(codeId, userId);
    }

    @PostMapping("/code/{codeId}/user/{userId}/like")
    public void like(@PathVariable long codeId, @PathVariable long userId) {
        ratingService.like(codeId, userId);
    }

     @DeleteMapping("/code/{codeId}/user/{userId}")
    public void delete(@PathVariable long codeId, @PathVariable long userId) {
        ratingService.removeRating(codeId, userId);
     }
}
