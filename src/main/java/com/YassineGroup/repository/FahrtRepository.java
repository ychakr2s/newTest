package com.YassineGroup.repository;

import com.YassineGroup.model.Fahrt;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("fahrtRepository")
public interface FahrtRepository extends CrudRepository<Fahrt, Integer> {

//    Fahrt findByPlace(String place);
//    public void saveF(Fahrt fahrt);


}
