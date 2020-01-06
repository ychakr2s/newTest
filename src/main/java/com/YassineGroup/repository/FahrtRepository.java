package com.YassineGroup.repository;

import com.YassineGroup.model.Fahrt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.HashSet;

@Repository("fahrtRepository")
public interface FahrtRepository extends JpaRepository<Fahrt, Integer> {

//    Page<Comment> findByPostId(Long postId, Pageable pageable);

    HashSet<Fahrt> findFahrtByUserId(int id);

//    Fahrt findById(int id);

//    public void delete(Fahrt fahrt);

    public void delete(int fahrtId);

//    @Query(value = "SELECT u FROM User u WHERE u.name IN :names")
//    void delete(@Param("names") Collection<String> names);

//    public Fahrt findByIdAndFahrtId(int fahrtId, int userId);


//    Fahrt findByPlace(String place);
//    public void saveF(Fahrt fahrt);


}
