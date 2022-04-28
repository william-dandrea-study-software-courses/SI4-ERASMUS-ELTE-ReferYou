package com.referyou.distributionservice.service;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author D'Andréa William
 */
public class DistributionService {


    @GetMapping(path="/")
    public String getHomePage(Model model) {
        return "index";
    }



}
