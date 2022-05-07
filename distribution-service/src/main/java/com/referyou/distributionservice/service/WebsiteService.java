package com.referyou.distributionservice.service;

import com.referyou.distributionservice.entity.Code;
import com.referyou.distributionservice.entity.Website;
import com.referyou.distributionservice.repository.WebsiteRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class WebsiteService {


    private final WebsiteRepository websiteRepository;

    public WebsiteService(WebsiteRepository websiteRepository) {
        this.websiteRepository = websiteRepository;
    }

    public Website create(Website website) {
        if(websiteRepository.existsById(website.getId()))
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "The chosen id already exist.");
        return websiteRepository.save(website);
    }

    public Website update(long websiteId, Website website) {
        website.setId(websiteId);
        return websiteRepository.save(website);
    }

    public void destroy(long websiteId) {
        websiteRepository.deleteById(websiteId);
    }

    public List<Code> getCodes(long websiteId) {
        return websiteRepository.findById(websiteId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Website not found."))
                .getCodes();
    }

    public Iterable<Website> getAll() {
        return websiteRepository.findAll();
    }

    public Website get(long websiteId) {
        return websiteRepository.findById(websiteId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Website not found."));
    }
}
