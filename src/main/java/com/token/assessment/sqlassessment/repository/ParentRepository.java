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

}
