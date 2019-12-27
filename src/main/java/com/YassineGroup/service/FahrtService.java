package com.YassineGroup.service;

import com.YassineGroup.model.Fahrt;
import com.YassineGroup.repository.FahrtRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.ArrayList;
import java.util.List;

public class FahrtService {

    private FahrtRepository fahrtRepository;

    @Autowired
    public FahrtService(@Qualifier("userRepository") FahrtRepository fahrtRepository) {
        this.fahrtRepository = fahrtRepository;
    }

    public void saveUser(Fahrt fahrt) {
        fahrtRepository.save(fahrt);
    }


    public List<Fahrt> showAllFahrts() {
        List<Fahrt> fahrts = new ArrayList<Fahrt>();
        for (Fahrt fahrt : fahrtRepository.findAll()) {
            fahrts.add(fahrt);
        }

        return fahrts;
    }
}
