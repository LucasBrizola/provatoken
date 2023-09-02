package com.token.assessment.sqlassessment.service;

import com.token.assessment.sqlassessment.model.Child;
import com.token.assessment.sqlassessment.model.Parent;
import com.token.assessment.sqlassessment.repository.ChildRepository;
import com.token.assessment.sqlassessment.repository.ParentRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class SqlService {
    private final ParentRepository parentRepository;

    private final ChildRepository childRepository;

    List<String> parentsName = new ArrayList<>();

    public SqlService(ParentRepository parentRepository, ChildRepository childRepository) {
        this.parentRepository = parentRepository;
        this.childRepository = childRepository;
    }

    public List<String> getAllFathersNames() {
        Collection<Parent> parents = this.parentRepository.findAllFathersNames();
        List<String> parentsName = new ArrayList<>();
        for (Parent parent : parents
        ) {
            parentsName.add(parent.getName());
        }
        return parentsName;
    }

    public List<String> getAllFathersNamesWithMoreThanOneChild() {
        Collection<Parent> parents = this.parentRepository.findAllFathersNamesWithMoreThanOneChild();
        List<String> parentsName = new ArrayList<>();
        for (Parent parent : parents
        ) {
            parentsName.add(parent.getName());
        }
        return parentsName;
    }

    public List<String> getAllFathersAndMothersNames() {
        Collection<Child> children = this.childRepository.findAllChildrenNames();
        children.forEach(child -> parentsName.add(child.getName()));
        Collection<Parent> parents = this.parentRepository.findAllFathersOfAllChildren();
        addNames(parents.stream().toList());
        parents = this.parentRepository.findAllMothersOfAllChildren();
        addNames(parents.stream().toList());

        return parentsName;
    }

    private void addNames(List<Parent> list) {
        for (int i = 0; i < parentsName.size(); i++) {
            StringBuilder line = new StringBuilder();
            line.append(parentsName.get(i));
            if (list.get(i).getName() != null) {
                line.append(" ").append(list.get(i).getName());
            }
            parentsName.set(i, line.toString());
        }
    }

    public int getJohnChildrens(){
        return childRepository.getChildrenFromJohn();
    }

}
