package com.simbirsoft.javacourse.service;


import com.simbirsoft.javacourse.constants.PersonPropertyKeys;
import com.simbirsoft.javacourse.entity.PersonalData;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

@Component
public class GetProperty {

    private Properties prop;

    public void getProperties(InputStream InStream){
        prop = new Properties();
        try {
            prop.load(new InputStreamReader(InStream));
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
        finally {
            try {
                InStream.close();
            } catch (IOException ex){
                System.out.println(ex.getMessage());
            }

        }

    }



    public PersonalData getDataFromProperty(){
        PersonalData data = null;
        data = new PersonalData(
                prop.getProperty(PersonPropertyKeys.FIO),
                prop.getProperty(PersonPropertyKeys.DOB),
                prop.getProperty(PersonPropertyKeys.PHONE),
                prop.getProperty(PersonPropertyKeys.EMAIL),
                prop.getProperty(PersonPropertyKeys.SKYPE),
                prop.getProperty(PersonPropertyKeys.AVATAR),
                prop.getProperty(PersonPropertyKeys.TARGET),
                prop.getProperty(PersonPropertyKeys.EXPERIENCES),
                prop.getProperty(PersonPropertyKeys.EDUCATIONS),
                prop.getProperty(PersonPropertyKeys.ADDITIONAL_EDUCATIONS),
                prop.getProperty(PersonPropertyKeys.SKILLS)
        );
        return data;
    }
}
