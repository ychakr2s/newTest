package com.YassineGroup.service;

import com.YassineGroup.model.User;
import com.YassineGroup.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service("userService")
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

//    public User findByConfirmationToken(String confirmationToken) {
//        return userRepository.findByConfirmationToken(confirmationToken);
//    }

    @Transactional
    public void saveUser(User user) {
        userRepository.save(user);
    }

//    public void save(User user) {
//    }
}
