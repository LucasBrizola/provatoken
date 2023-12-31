package com.token.assessment.sqlassessment.repository;

import com.token.assessment.sqlassessment.model.Child;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface ChildRepository extends JpaRepository<Child, Long> {

    @Query(value = "SELECT * FROM CHILD",
            nativeQuery = true)
    Collection<Child> findAllChildrenNames();

    @Query(value = "SELECT count(father_id) FROM CHILD where father_id = ?1",
            nativeQuery = true)
    int getChildrenFromFather(int id);

    @Query(value = "SELECT count(mother_id) FROM CHILD where mother_id = ?1",
            nativeQuery = true)
    int getChildrenFromMother(int id);
}
