package com.referyou.distributionservice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author D'Andréa William
 */

@RestController
@RequestMapping("/distribution")
public class PageController {


    @GetMapping("")
    public ResponseEntity<String> getDistributionTest() {
        return ResponseEntity.ok("Test");
    }



}

