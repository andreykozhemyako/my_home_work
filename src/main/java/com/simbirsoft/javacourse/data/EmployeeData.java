package com.simbirsoft.javacourse.data;


import com.simbirsoft.javacourse.entity.PersonalData;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class EmployeeData implements PersonalDataInterface{

    private Map<Long, PersonalData> persons = new HashMap<>();
    public List<PersonalData> getAll() {
        return new ArrayList<>(persons.values());
    }
}
