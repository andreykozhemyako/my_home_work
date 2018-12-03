package com.simbirsoft.javacourse.service;


import com.simbirsoft.javacourse.data.EmployeeData;
import com.simbirsoft.javacourse.entity.PersonalData;
import com.simbirsoft.javacourse.repository.PersonRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SummaryService {

    private EmployeeData data;

    @Autowired
    private GetProperty property;

    @Autowired
    private PersonRepository repos;

    @Autowired
    SummaryService(EmployeeData data) {
        this.data = data;
    }

    public void addPerson(PersonalData person){
        repos.save(person);
    }

    public PersonalData getData(String pass){
        property.getProperties(getClass().getClassLoader().getResourceAsStream(pass));
        return property.getDataFromProperty();
    }

    public List<PersonalData> getPersonById(Long id){

        return repos.findById(id);

    }

    public List<PersonalData> getAll() {
        return repos.findAll();
    }

}
