package com.YassineGroup.repository;

import com.YassineGroup.model.Fahrt;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FahrtRepository extends CrudRepository<Fahrt, String> {

//    Fahrt findByPlace(String place);
}
