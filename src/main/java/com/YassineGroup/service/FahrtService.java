package com.YassineGroup.service;

import com.YassineGroup.model.Fahrt;
import com.YassineGroup.model.User;
import com.YassineGroup.repository.FahrtRepository;
import com.YassineGroup.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.config.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

@Service
@Transactional
public class FahrtService {

    private FahrtRepository fahrtRepository;

    private UserRepository userRepository;

    @Autowired
    public FahrtService(@Qualifier("fahrtRepository") FahrtRepository fahrtRepository) {
        this.fahrtRepository = fahrtRepository;
    }

    public Fahrt saveFahrt(Fahrt fahrt) {
        return fahrtRepository.save(fahrt);
    }

    public Fahrt createFahrt(int userId, Fahrt fahrt) throws ResourceNotFoundException {

        Set<Fahrt> fahrts = new HashSet<>();
        User user1 = new User();
        Optional<User> byId = Optional.ofNullable(userRepository.findById(userId));
        if (!byId.isPresent()) {
//            throw new ResourceNotFoundException();
            System.out.println("Nein geht nicht");
        }
        User user = byId.get();
        fahrt.setUser(user);

        Fahrt fahrt1 = fahrtRepository.save(fahrt);
        //tie Book to Author
        fahrts.add(fahrt1);
        user1.setFahrt(fahrts);

        return fahrt1;

    }


    public List<Fahrt> showAllFahrts() {
        List<Fahrt> fahrts = new ArrayList<Fahrt>();
        for (Fahrt fahrt : fahrtRepository.findAll()) {
            fahrts.add(fahrt);
        }

        return fahrts;
    }
}
