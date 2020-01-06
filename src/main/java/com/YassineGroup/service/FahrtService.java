package com.YassineGroup.service;

import com.YassineGroup.model.Fahrt;
import com.YassineGroup.repository.FahrtRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Transactional
public class FahrtService {

    private FahrtRepository fahrtRepository;

//    private UserService userService;

    @Autowired
    public FahrtService(@Qualifier("fahrtRepository") FahrtRepository fahrtRepository) {
        this.fahrtRepository = fahrtRepository;
    }

    //    public void deleteMyUser(int id) {
//        userRepository.deleteById(id);
//    }
    public Fahrt findFahrtById(int id) {
        return fahrtRepository.findOne(id);
    }

    public void deleteFahrt(int fahrtId) {
        this.fahrtRepository.delete(fahrtId);
    }

    public Fahrt saveFahrt(Fahrt fahrt) {
        return fahrtRepository.save(fahrt);
    }

//    public Fahrt findFahrtByIdAndFahrtId(int fahrtId, int userId) {
//        return fahrtRepository.findByIdAndFahrtId(fahrtId, userId);
//    }

    //    public Fahrt createFahrt(int userId, Fahrt fahrt) throws ResourceNotFoundException {
//
//        Set<Fahrt> fahrts = new HashSet<>();
//        User user1 = new User();
//        Optional<User> byId = Optional.ofNullable(userRepository.findById(userId));
//        if (!byId.isPresent()) {
////            throw new ResourceNotFoundException();
//            System.out.println("Nein geht nicht");
//        }
//        User user = byId.get();
//        fahrt.setUser(user);
//
//        Fahrt fahrt1 = fahrtRepository.save(fahrt);
//        //tie Book to Author
//        fahrts.add(fahrt1);
//        user1.setFahrt(fahrts);
//
//        return fahrt1;
//
//    }
    public HashSet<Fahrt> showUsersFahrts(int id) {
//        User user = userService.findUserById(id);
        System.out.println("Richtig drin in usersfahrts ");
        Set<Fahrt> fahrts = new HashSet<Fahrt>();
//        fahrts = user.getFahrt();
        fahrts = fahrtRepository.findFahrtByUserId(id);

//        Set<Fahrt> fahrtsReturn = new HashSet<Fahrt>();
//
//        for (Fahrt fahrt : fahrtRepository.findAll()) {
//            fahrts.add(fahrt);
//        }

        return (HashSet<Fahrt>) fahrts;
    }


    public List<Fahrt> showAllFahrts() {
        List<Fahrt> fahrts = new ArrayList<Fahrt>();
        for (Fahrt fahrt : fahrtRepository.findAll()) {
            fahrts.add(fahrt);
        }

        return fahrts;
    }

//    public List<User> showAllUsers() {
//        List<User> users = new ArrayList<User>();
//        for (User user : userRepository.findAll()) {
//            users.add(user);
//        }
//
//        return users;
//    }
}
