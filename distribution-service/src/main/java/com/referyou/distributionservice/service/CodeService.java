package com.referyou.distributionservice.service;

import com.referyou.distributionservice.entity.Code;
import com.referyou.distributionservice.repository.CodeRepository;
import com.referyou.distributionservice.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class CodeService {

    private final CodeRepository codeRepository;
    private final UserRepository userRepository;

    public CodeService(CodeRepository codeRepository, UserRepository userRepository) {
        this.codeRepository = codeRepository;
        this.userRepository = userRepository;
    }

    public Code create(Code code) {
        if(codeRepository.existsById(code.getId()))
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Code already exist with this id.");
        return codeRepository.save(code);
    }

    public Code update(long codeId, Code code) {
        code.setId(codeId);
        return codeRepository.save(code);
    }

    public void destroy(long codeId) {
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
