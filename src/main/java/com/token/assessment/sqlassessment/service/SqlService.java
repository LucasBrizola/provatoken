package com.token.assessment.sqlassessment.service;

import com.token.assessment.sqlassessment.model.Parent;
import com.token.assessment.sqlassessment.repository.ParentRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class SqlService {
    private final ParentRepository parentRepository;

    public SqlService(ParentRepository parentRepository){
        this.parentRepository = parentRepository;
    }

    public List<String> getAllFathersNames(){
        Collection<Parent> parents = this.parentRepository.findAllFathersNames();
        List<String> parentsName = new ArrayList<>();
        for (Parent parent: parents
             ) {
            parentsName.add(parent.getName());
        }
        return parentsName;
    }


}
