package com.YassineGroup.repository;

import com.YassineGroup.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository {

    User findByEmail(String lastname);

    User findById(Long id);
}
