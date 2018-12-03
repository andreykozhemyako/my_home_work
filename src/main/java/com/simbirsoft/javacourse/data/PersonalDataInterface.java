package com.simbirsoft.javacourse.data;

import com.simbirsoft.javacourse.entity.PersonalData;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface PersonalDataInterface {

    List<PersonalData> getAll();

}
