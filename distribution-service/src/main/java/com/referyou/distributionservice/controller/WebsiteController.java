package com.referyou.distributionservice.controller;

import com.referyou.distributionservice.entity.Website;
import com.referyou.distributionservice.service.WebsiteService;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.PathParam;

@RestController
@RequestMapping("distribution/website")
public class WebsiteController {

    private final WebsiteService websiteService;

    public WebsiteController(WebsiteService websiteService) {
        this.websiteService = websiteService;
    }

    @GetMapping()
    public Iterable<Website> getAll() {
        return websiteService.getAll();
    }

    @GetMapping("{websiteId}")
    public Website getWebsite(@PathVariable long websiteId) {
        return websiteService.get(websiteId);
    }

    @PostMapping()
    public Website create(@RequestBody Website website) {
        return websiteService.create(website);
    }

    @PutMapping("{websiteId}")
    public Website update(@PathVariable long websiteId, @RequestBody Website website) {
        return websiteService.update(websiteId, website);
    }

    @DeleteMapping("{websiteId}")
    public void destroy(@PathVariable long websiteId) {
        websiteService.destroy(websiteId);
    }

}
