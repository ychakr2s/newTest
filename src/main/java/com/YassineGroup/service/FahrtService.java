package com.YassineGroup.service;

import com.YassineGroup.model.Fahrt;
import com.YassineGroup.repository.FahrtRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class FahrtService {

    private FahrtRepository fahrtRepository;

    @Autowired
    public FahrtService(@Qualifier("userRepository") FahrtRepository fahrtRepository) {
        this.fahrtRepository = fahrtRepository;
    }

    public void saveUser(Fahrt fahrt) {
        fahrtRepository.save(fahrt);
    }

}
