package com.YassineGroup.controller;

import com.YassineGroup.model.Fahrt;
import com.YassineGroup.model.User;
import com.YassineGroup.repository.FahrtRepository;
import com.YassineGroup.repository.UserRepository;
import com.YassineGroup.service.FahrtService;
import com.YassineGroup.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

//import org.springframework.data.jpa.repository.Query;

@Controller
public class UserCotroller {

    // This means to get the bean called userRepository
    // Which is auto-generated by Spring, we will use it to handle the data
    @Autowired
    UserService userService;

    @Qualifier("fahrtService")
    @Autowired
    FahrtService fahrtService;

    FahrtRepository fahrtRepository;
    UserRepository userRepository;

    private int userId;
    //    @Autowired
//    private FahrtService fahrtService;

    public UserCotroller(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String welcomeHome(Model model) {
        model.addAttribute("user", new User());
        return "index";
    }

    @GetMapping("/register")
    public String registerHome(Model model) {
        model.addAttribute("user", new User());
        return "registrieren";
    }

    @PostMapping("/register")
    public String formSubmit(@ModelAttribute("user") User user, Model modelAndView) {

        User existingUser = userService.findUserByEmail(user.getEmail());

        if (existingUser != null) {

            modelAndView.addAttribute("message", "This email already exists!");
            modelAndView.addAttribute("register");

            System.out.println("schon hier");
        } else {
            userService.saveUser(user);
            modelAndView.addAttribute("message", "Sie haben sich erfolgreich registriert");
            modelAndView.addAttribute("register");
        }

        System.out.println("Hello: " + user.getEmail());

        return "register";
    }

    @GetMapping("/loggin")
    public String loginHome(Model model) {
        model.addAttribute("user", new User());
        return "loggin";
    }

    @RequestMapping("/login-user")
    public String loginUser(@ModelAttribute User user, HttpServletRequest request, Model model) {
        model.addAttribute("loggin", new User());


        User existingUser = userService.findUserByUsernameAndPassword(user.getUsername(), user.getPassword());
        System.out.println("FROM DATABASE " + user.getEmail() + " " + user.getPassword() + " " + user.getUsername() + " " + user.getId());

        if (existingUser != null) {
//            System.out.println("der id ist: " + userService.findUserIdByUsernameAndPassword(user.getUsername(), user.getPassword()));
//            System.out.println("das ist richtig " + userService.findUserById(1).getName());
            userId = existingUser.getId();
            System.out.println("my Id " + userId);
            model.addAttribute("message", "Sie sind eingeloggt!");
            return "mainIndex";
        } else {
            model.addAttribute("message", "Invalid Username or Password! ");
            System.out.println("Nein nLeider hejt nicht");
            return "error";
        }
    }

    @GetMapping("/fahrtt")
    public String testfahrt(Model model) {

        User user = new User("name", "lastname", "username", "yassine@yahoo.de", "password");

        Set<Fahrt> fahr = new HashSet<Fahrt>();

// Create Comments
        Fahrt fahrt = new Fahrt("fromt", "tot", "dateez", 25, "placte", user);

        Fahrt fahrt1 = new Fahrt("from", "to", "datee", 25, "plact", user);
        fahr.add(fahrt);
        fahr.add(fahrt1);
        user.setFahrt(fahr);
        fahrt.setUser(user);

        System.out.println(fahrt.toString());

        System.out.println("Ich bin drin");
        System.out.println(user.getFahrt().size());

        user.getFahrt().add(fahrt);

        System.out.println("Ich bin drin");

        userService.saveUser(user);

        System.out.println("Ich bin drin saved");
        System.out.println(user.getFahrt().toString());
        System.out.println("Ich bin drin show");

        return "test";
    }

    @GetMapping("/showFahrt")
    public String showfahr(Model model) {
        model.addAttribute("fahrt", new Fahrt());
        return "fahrtHunzufuegen";
    }

//    @GetMapping("/addFahrt")
//    public String addFahr(@ModelAttribute User user, HttpServletRequest request, Model model) {
//        model.addAttribute("fahrt", new Fahrt());
//        return "fahrtHunzufuegen";
//    }

    @PostMapping("/addFahrt")
    public String addFahr(@ModelAttribute("fahrt") Fahrt fahrt, Model modelAndView) {
//        postRepository.findById(postId).map(post -> { comment.setPost(post); return commentRepository.save(comment);
        User user = userRepository.findById(userId);
        fahrt.setUser(user);
        Set<Fahrt> fahr = new HashSet<Fahrt>();
        fahr.add(fahrt);
//        fahr.
        fahrtRepository.save(fahr);
        user.setFahrt(fahr);

//        fahrt.getUser().setFahrt(fahr);
        System.out.println("alles ist Richtig");

//        User existingUser = userService.findUserByEmail(user.getEmail());
//
//        if (existingUser != null) {
//
//            modelAndView.addAttribute("message", "This email already exists!");
//            modelAndView.addAttribute("register");
//
//            System.out.println("schon hier");
//        } else {
//            userService.saveUser(user);
//            modelAndView.addAttribute("message", "Sie haben sich erfolgreich registriert ");
//            modelAndView.addAttribute("register");
//        }
//
//        System.out.println("Hello: " + user.getEmail());

        return "register";
    }

    @GetMapping("/show-fahrt")
    public String sowhfahrt(@ModelAttribute User user, HttpServletRequest request, Model model) {
//        model.addAttribute("user", new User());
//        Set<Fahrt> fahr = new HashSet<Fahrt>();
//
//        User user = new User("name", "lastname", "username", "yassine@yahoo.de", "password");
////        ( "name",  "lastname",  "username",  "email_Adresse",  "password")
//
//// Create Comments
//        Fahrt fahrt = new Fahrt("fromt", "tot", "dateez", 25, "placte", user);
//        fahr.add(fahrt);
//        user.setFahrt(fahr);
//        fahrt.setOneUser(user);
//
//        System.out.println(fahrt.toString());

        System.out.println("Ich bin drin");
//        System.out.println(userService.s);

        System.out.println(user.getFahrt().toString());


//        user.getFahrt().add();


        System.out.println("Ich bin drin");

//        userService.saveUser(user);

        System.out.println("Ich bin drin");

        return "test";
    }

    @PostMapping(value = "/createFahrt")
    public String createFahrt(@Valid @ModelAttribute("fahrt") Fahrt fahrt, BindingResult result, Model modelAndView) {
        System.out.println("nocht nicht executed is: " + fahrt.getDepart());
//        Long userId = fahrt.getUser().getId();
//        int a = Math.toIntExact(userId);
//        System.out.println(a+ " hier");
        System.out.println("Create Fahrt : " + userId);
        User user = userService.findUserById(userId);
        System.out.println("nocht nicht executed is: " + fahrt.getDepart());

//        fahrt.setUser(user);
//        Set<Fahrt> fahr = new HashSet<Fahrt>();
//        fahr.add(fahrt);
//        user.setFahrt(fahr);
        System.out.println("nocht nicht executed is: " + fahrt.getDepart());

        System.out.println("doch is id executed");
//        System.out.println(userId);
        System.out.println("doch is id executed");

//        fahrtService.createFahrt(userId, fahrt);
        System.out.println("nocht schon executed");

//        return user.map(user -> {
        fahrt.setUser(user);
        fahrtService.saveFahrt(fahrt);
//        return courseRepository.save(course);
        System.out.println("interNational");

//        fahr.
//        fahrtService.saveFahrt(fahrt);
        modelAndView.addAttribute("message", "Yeh.. you saved the Fahrt!!");
        modelAndView.addAttribute("register");

/*
        fahrtRepository.save(fahr);
        user.setFahrt(fahr);

//        fahrt.getUser().setFahrt(fahr);
        System.out.println("alles ist Richtig");
        Set<Fahrt> fahr = new HashSet<Fahrt>();
//        Fahrt fahrt1 = new Fahrt("from", "to", "datee", 25, "plact", user);

        fahr.add(fahrt);
        System.out.println("nocht  executed is: " + fahrt.getDepart());
        fahrt.getUser().setFahrt(fahr);
        fahrtRepository.save(fahrt);
        fahr.add(fahrt1);
        user.setFahrt(fahr);
        fahrt.setUser(user);
*/

//        return "index";
        return "mainIndex";
    }

    @GetMapping(value = "/display_Fahrt")
    public String displayFahrt(@ModelAttribute("fahrt") Fahrt fahrt, Model modelAndView) {
        System.out.println("Ich bin drin in dispay");
        User user = userService.findUserById(userId);
        System.out.println("Richtig " + user.getName());
        System.out.println(user.getFahrt() + " ; " + fahrtService.showUsersFahrts(userId));

        HashSet<Fahrt> fahrts = new HashSet<Fahrt>();
        fahrts = fahrtService.showUsersFahrts(userId);
        System.out.println(fahrts.iterator().next());

        TreeSet myTreeSet = new TreeSet();
        myTreeSet.addAll(fahrts);

        modelAndView.addAttribute("fahrts", myTreeSet);

        return "mainIndex";
    }

    @GetMapping("/delete-fahrt/{id}")
    public String deleteFahrt(@PathVariable("id") int id) {
//        if (fa.existUser(id)) {
        System.out.println("heyyy  guck mal ..... ich bin in delete : " + id);
//        Fahrt fahrt = fahrtService.findFahrtById(id);
        System.out.println("fahrt ist gefunden");

        fahrtService.deleteFahrt(id);

        System.out.println("fahrt ist geloescht");
        System.out.println("fahrt ist schon weg");

        return "redirect:/display_Fahrt";
//        return  "update-fahrt.html";
    }

    @GetMapping("/edit-fahrt/{id}")
    public String editTheFahrt(@PathVariable("id") int id, Model model) {
//        if (fa.existUser(id)) {
        System.out.println("heyyy  guck mal ..... ich bin in edit : " + id);
//        Fahrt fahrt = fahrtService.findFahrtById(id);
        System.out.println("fahrt ist gefunden");

        Fahrt fahrt = fahrtService.findFahrtById(id);
//                .getEmployeeById(id.get());
        model.addAttribute("fahrt", fahrt);

//        fahrtService.deleteFahrt(id);

        System.out.println("fahrt ist geloescht");
        System.out.println("fahrt ist schon weg");
        return "update_fahrt";
//        return "redirect:/showFahrt";
    }


//    @RequestMapping("/edit-user")
//    public String editUser(@RequestParam int id, HttpServletRequest request) {
//        request.setAttribute("user", userService.editUser(id));
//        request.setAttribute("mode", "MODE_UPDATE");
//        return "welcomepage";
//    }

    @PostMapping("/update/{id}")
    public String updateUser(@PathVariable("id") int id, @Valid Fahrt fahrt,
                             BindingResult result, Model model) {
//        if (result.hasErrors()) {
//            fahrt.setId(id);
//            return "update-user";
//        }

        fahrtService.saveFahrt(fahrt);
//        userRepository.save(user);
//        model.addAttribute("f", userRepository.findAll());
        return "redirect:/showFahrt";
    }
}
