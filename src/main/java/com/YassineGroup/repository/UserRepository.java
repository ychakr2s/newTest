package com.YassineGroup.repository;

import com.YassineGroup.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("userRepository")
public interface UserRepository extends CrudRepository<User, Long> {

    User findByEmail(String email);

    User findByUsernameAndPassword(String username, String password);

    User findById(Long userId);

}
