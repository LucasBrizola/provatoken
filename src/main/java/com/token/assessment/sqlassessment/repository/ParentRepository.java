package com.token.assessment.sqlassessment.repository;

import com.token.assessment.sqlassessment.model.Parent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface ParentRepository extends JpaRepository<Parent, Long> {

    @Query(value = "SELECT DISTINCT p.id, p.NAME FROM PARENT p INNER JOIN CHILD c ON c.FATHER_ID = p.ID",
            nativeQuery = true)
    Collection<Parent> findAllFathersNames();

    @Query(value = "SELECT p.NAME, p.ID FROM CHILD c\n" +
            "INNER JOIN PARENT p ON c.FATHER_ID = p.ID\n" +
            "GROUP BY FATHER_ID HAVING COUNT( * )>1;",
            nativeQuery = true)
    Collection<Parent> findAllFathersNamesWithMoreThanOneChild();

    @Query(value = "SELECT c.id, p.name\n" +
            "FROM Parent p\n" +
            "RIGHT JOIN Child c\n" +
            "ON c.father_id = p.id\n" +
            "ORDER BY c.id;",
            nativeQuery = true)
    Collection<Parent> findAllFathersOfAllChildren();

    @Query(value = "SELECT c.id, p.name\n" +
            "FROM Parent p\n" +
            "RIGHT JOIN Child c\n" +
            "ON c.mother_id = p.id\n" +
            "ORDER BY c.id;",
            nativeQuery = true)
    Collection<Parent> findAllMothersOfAllChildren();

}
