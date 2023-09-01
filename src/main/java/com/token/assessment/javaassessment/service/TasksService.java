package com.token.assessment.javaassessment.service;

import com.token.assessment.javaassessment.model.Person;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

@Service
public class TasksService {
    public Person[] reverseNewArray(Person[] names) {
        Person[] namesReversed = new Person[names.length];
        int namesSize = names.length - 1;
        int j = 0;
        for (int i = namesSize; i >= 0; i--) {
            namesReversed[j] = names[i];
            j++;
        }

        return namesReversed;
    }

    public Person[] reverseSameArray(Person[] names) {
        Person name;
        int last = names.length;
        for (int i = 0; i < last / 2; i++) {
            name = names[i];
            names[i] = names[last - i - 1];
            names[last - i - 1] = name;
        }

        return names;
    }

    public List<Person> reverseList(List<Person> names) {
        Collections.reverse(names);
        return names;
    }

    //in case Collections.reverse is cheating
    public List<Person> manualReverseList(List<Person> names) {
        int last = names.size() - 1;
        for (int i = 0; i < last; i++) {
            Person lastPerson = names.remove(last);
            names.add(i, lastPerson);
        }

        return names;
    }

    public String[] readFile() {
        String[] names = null;
        String csvFile = "C:/Users/Usuario/Desktop/provatoken/src/main/resources/names.csv";
        try {
            File file = new File(csvFile);
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                names = fixNamesAndReturnArray(line);
            }
            br.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return names;
    }

    public String[] fixNamesAndReturnArray(String line) {
        int i = 0;
        String[] tempArr = line.split(",");
        String[] names = new String[tempArr.length];
        for (String tempStr : tempArr) {
            StringBuilder sb = new StringBuilder(tempStr.substring(0, tempStr.length() - 1));
            names[i] = sb.delete(0, 1).toString();
            i++;
        }
        return names;
    }
}
