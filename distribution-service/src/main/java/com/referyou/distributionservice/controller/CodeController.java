package com.referyou.distributionservice.controller;

import com.referyou.distributionservice.entity.Code;
import com.referyou.distributionservice.service.CodeService;
import com.referyou.distributionservice.service.WebsiteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("distribution/code")
public class CodeController {


    private final CodeService codeService;
    private final WebsiteService websiteService;

    public CodeController(CodeService codeService, WebsiteService websiteService) {
        this.codeService = codeService;
        this.websiteService = websiteService;
    }

    @PostMapping()
    public Code create(@RequestBody Code code) {
        return codeService.create(code);
    }



    @DeleteMapping("{codeId}")
    public void destroy(@PathVariable long codeId) {
        codeService.destroy(codeId);
    }

    @PutMapping("{codeId}")
    public Code update(@PathVariable long codeId, @RequestBody Code code) {
        return codeService.update(codeId, code);
    }

    @GetMapping("/by-user/{userId}")
    public List<Code> codeByUser(@PathVariable long userId) {
        return codeService.getByUser(userId);
    }

    @GetMapping("/by-website/{websiteId}")
    public List<Code> codeByWebsite(@PathVariable long websiteId) {
        return websiteService.getCodes(websiteId);
    }

    @GetMapping("/by-code/{codeId}")
    public Code getCodeById(@PathVariable long codeId) {
        return codeService.getById(codeId);
    }


    @GetMapping()
    public Iterable<Code> getAllCodes() {
        return codeService.getAll();
    }
}
