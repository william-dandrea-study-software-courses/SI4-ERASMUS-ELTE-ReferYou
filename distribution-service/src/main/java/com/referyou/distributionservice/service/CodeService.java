package com.referyou.distributionservice.service;

import com.referyou.distributionservice.entity.Code;
import com.referyou.distributionservice.repository.CodeRepository;
import com.referyou.distributionservice.repository.UserRepository;
import com.referyou.distributionservice.repository.WebsiteRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class CodeService {

    private final CodeRepository codeRepository;
    private final UserRepository userRepository;
    private final WebsiteRepository websiteRepository;

    public CodeService(CodeRepository codeRepository, UserRepository userRepository, WebsiteRepository websiteRepository) {
        this.codeRepository = codeRepository;
        this.userRepository = userRepository;
        this.websiteRepository = websiteRepository;
    }

    public Code create(Code code) {
        if(codeRepository.existsById(code.getId()))
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Code already exist with this id.");
        if(!userRepository.existsById(code.getOwnerId()))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
        if(!websiteRepository.existsById(code.websiteId))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Website not found");
        return codeRepository.save(code);
    }

    public Code update(long codeId, Code code) {
        if(!codeRepository.existsById(codeId))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Code not found");
        if(!userRepository.existsById(code.getOwnerId()))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
        if(!websiteRepository.existsById(code.websiteId))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Website not found");
        code.setId(codeId);
        return codeRepository.save(code);
    }

    public void destroy(long codeId) {
        if(!codeRepository.existsById(codeId))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Code not found");
        codeRepository.deleteById(codeId);
    }

    public List<Code> getByUser(long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found."))
                .codes;
    }

    public Iterable<Code> getAll() {
        return codeRepository.findAll();
    }

    public Code getById(long codeId) {
        return this.codeRepository.findById(codeId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Code not found."));
    }
}
