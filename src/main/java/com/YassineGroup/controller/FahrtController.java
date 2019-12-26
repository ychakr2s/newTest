package com.YassineGroup.controller;

import com.YassineGroup.model.Fahrt;
import com.YassineGroup.model.User;
import com.YassineGroup.repository.FahrtRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FahrtController {

    @Autowired
    private FahrtRepository fahrtRepository;

//    @GetMapping("/fahrts")
//    public List<Fahrt> getAllFahrts() {
//        List<Fahrt> fahrts = new ArrayList<Fahrt>();
//        for (Fahrt fahrt : fahrtRepository.findAll()) {
//            fahrts.add(fahrt);
//        }
//
//        return fahrts;
//    }

    // Create a Post

//    @PostMapping("/register")
//    public String formSubmit(@ModelAttribute("user") User user, Model modelAndView) {
//        // Create a Post
//        User user1 = new User("name", "lastname", "username", "yassine@yahoo.de", "password");
////        ( "name",  "lastname",  "username",  "email_Adresse",  "password")
//
//// Create Comments
//        Fahrt fahrt = new Fahrt("from", "to", "date", 25, "place", user1);
//        fahrt.setUser(user);
//        System.out.println("Ich bin drin");
//
//        return "";
//    }



}

