package com.YassineGroup.repository;

import com.YassineGroup.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("userRepository")
public interface UserRepository extends CrudRepository<User, String> {

    User findByEmail(String email);
    User findByUsernameAndPassword(String username, String password);

}
