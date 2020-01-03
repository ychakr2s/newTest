package com.YassineGroup.controller;

import com.YassineGroup.model.Fahrt;
import com.YassineGroup.repository.FahrtRepository;
import com.YassineGroup.repository.UserRepository;
import com.YassineGroup.service.FahrtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.Set;

@RestController
public class FahrtController {

    @Autowired
    private FahrtRepository fahrtRepository;
    private FahrtService fahrtService;

    int id;
//    @Autowired
//    private CommentRepository commentRepository;

    @Autowired
    @Qualifier(value = "userRepository")
    private UserRepository userRepository;

//    @PostMapping("/createFahrt")
//    public String createComment(@PathVariable(value = "userId") Long userId,
//                                @Valid @RequestBody Fahrt fahrt) {

    @PostMapping("/{userId}/fahrt")
    public String createFahrt(@RequestParam(value = "userId") int userId, @ModelAttribute("fahrt") Fahrt fahrt) {

        System.out.println("Bruder ich bin drin");

        Set<Fahrt> fahr = new HashSet<Fahrt>();
        fahr.add(fahrt);
        System.out.println("Bruder fahrt ist hinzugefügt");

        userRepository.findById(userId).setFahrt(fahr);
        fahrtRepository.save(fahrt);


//        fahrt.getOneUser().setFahrt(fahr);
        System.out.println("Bruder alles ist Richtig");


//        return postRepository.findById(postId).map(post -> {
//            comment.setPost(post);
//            return commentRepository.save(comment);
//        }).orElseThrow(() -> new ResourceNotFoundException("PostId " + postId + " not found"));

        return "index";
    }

    //Book
//    <input type="hidden" th:field="*{id}"/>




//    @PostMapping(value = "/createFahrt")
//    public String createBook(@Valid @ModelAttribute("fahrt") Fahrt fahrt, BindingResult result, Model model) {
//        System.out.println("nocht nicht executed is: " + fahrt.getDepart());
////        Long userId = fahrt.getUser().getId();
////        int a = Math.toIntExact(userId);
////        System.out.println(a+ " hier");
//
//        Set<Fahrt> fahr = new HashSet<Fahrt>();
////        Fahrt fahrt1 = new Fahrt("from", "to", "datee", 25, "plact", user);
//
//        fahr.add(fahrt);
//        System.out.println("nocht  executed is: " + fahrt.getDepart());
//        fahrt.getUser().setFahrt(fahr);
//        fahrtRepository.save(fahrt);
//
////        fahr.add(fahrt1);
////        user.setFahrt(fahr);
////        fahrt.setUser(user);
//
//        System.out.println("doch is id executed");
////        System.out.println(userId);
//        System.out.println("doch is id executed");
//
////        fahrtService.createFahrt(userId, fahrt);
//        System.out.println("nocht schon executed");
//        return "index";
//    }


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

