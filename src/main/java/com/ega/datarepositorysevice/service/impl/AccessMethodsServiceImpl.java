package com.ega.datarepositorysevice.service.impl;

import com.ega.datarepositorysevice.model.AccessMethods;
import com.ega.datarepositorysevice.model.Bundle;
import com.ega.datarepositorysevice.repository.AccessMethodsRepository;
import com.ega.datarepositorysevice.service.AccessMethodsService;
import org.springframework.beans.factory.annotation.Autowired;
import reactor.core.publisher.Mono;

import java.util.Optional;

public class AccessMethodsServiceImpl implements AccessMethodsService {

    @Autowired
    AccessMethodsRepository accessMethodsRepository;

    @Override
    public Mono<AccessMethods> getAccessMethodsById(String id) {
        Optional<AccessMethods> accessMethodsOpt =  accessMethodsRepository.findById(id);
        return accessMethodsOpt.map(Mono::just).orElseGet(Mono::empty);
    }
}
