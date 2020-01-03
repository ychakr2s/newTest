package com.YassineGroup.service;

import com.YassineGroup.model.Fahrt;
import com.YassineGroup.model.User;
import com.YassineGroup.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(@Qualifier("userRepository") UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void saveUser(User user) {
        userRepository.save(user);
    }

    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public User findUserByUsernameAndPassword(String username, String password) {
        return userRepository.findByUsernameAndPassword(username, password);
    }

    public User findUserById(int id) {
        return userRepository.findById(id);
    }

    public Integer findUserIdByUsernameAndPassword(String username, String password) {
        return userRepository.findIdByUsernameAndPassword(username, password);
    }


}
