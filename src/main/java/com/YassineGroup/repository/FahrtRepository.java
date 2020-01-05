package com.YassineGroup.repository;

import com.YassineGroup.model.Fahrt;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.HashSet;

@Repository("fahrtRepository")
public interface FahrtRepository extends CrudRepository<Fahrt, Integer> {

//    Page<Comment> findByPostId(Long postId, Pageable pageable);

    HashSet<Fahrt> findFahrtByUserId(int id);

    Fahrt findById(int id);

    public void delete(Fahrt fahrt);


//    Fahrt findByPlace(String place);
//    public void saveF(Fahrt fahrt);


}
