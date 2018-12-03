package com.simbirsoft.javacourse.entity;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.*;

@Entity
@Table(name = "PERSONS")
public class PersonalData implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String FIO;                     //ФИО
    private String DOB;                     //Дата рождения
    private String phone;                   //телефон
    private String email;                   //электронная почта
    private String skype;                   //скайп
    private String avatar;                  //ссылка на аватарку
    private String target;                  //цель
    private String experiences;             //опыт работы
    private String educations;              //образование
    private String additionalEducations;    //дополнительное образование
    private String skills;                  //скилы

    private LinkedHashMap <String, Integer> skillsMap = new LinkedHashMap <>();
    public ArrayList <String> expList;

    public PersonalData() {

    }

    public PersonalData(String fio, String dob, String email) {
        this.FIO = fio;
        this.DOB = dob;
        this.email = email;
    }

    public PersonalData(String FIO, String DOB, String phone, String email, String skype, String avatar, String target, String experiences, String educations, String additionalEducations, String skills) {
        this.FIO = FIO;
        this.DOB = DOB;
        this.phone = phone;
        this.email = email;
        this.skype = skype;
        this.avatar = avatar;
        this.target = target;
        this.experiences = experiences;
        this.educations = educations;
        this.additionalEducations = additionalEducations;
        this.skills = skills;

    }


    public void readPropertyFile() {
        Properties prop = new Properties();
        InputStream input;
        //TreeMap <String, Integer> propvals = new TreeMap <>();
        try {

            input = PersonalData.class.getResourceAsStream("/person.properties");
            prop.load(input);
            expList = new ArrayList <>(Arrays.asList(experiences.split("/")));
            //String Skills = new String(prop.getProperty("skills").getBytes("ISO8859-1"));
            String[] strings = skills.split(", ");
            for (int i = 0; i < strings.length; i++) {
                String[] elements = strings[i].split(":");
                skillsMap.put(elements[0], Integer.parseInt(elements[1]));
            }
            skillsMap = (LinkedHashMap <String, Integer>) sortByValue(skillsMap);

            //System.out.println(MaxPosition(propvals));
            //System.out.println("TreeMap generated::" + propvals);


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public void makeSplit() {

        readPropertyFile();
    }


    public static <K, V extends Comparable <? super V>> Map <K, V> sortByValue(Map <K, V> map) {


        List <Map.Entry <K, V>> list = new LinkedList <>(map.entrySet());
        Collections.sort(list, new Comparator <Map.Entry <K, V>>() {
            @Override
            public int compare(Map.Entry <K, V> o1, Map.Entry <K, V> o2) {
                return (o2.getValue()).compareTo(o1.getValue());
            }
        });
        Map <K, V> result = new LinkedHashMap <>();
        for (Map.Entry <K, V> entry : list) {
            result.put(entry.getKey(), entry.getValue());
        }
        //System.out.println(result);
        return result;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Map <String, Integer> getSkillsMap() {
        return skillsMap;
    }

    public void setSkillsMap(LinkedHashMap <String, Integer> skillsMap) {
        this.skillsMap = skillsMap;
    }

    public ArrayList <String> getExpList() {
        return expList;
    }

    public void setExpList(ArrayList <String> expList) {
        this.expList = expList;
    }

    public String getFIO() {
        return FIO;
    }

    public void setFIO(String FIO) {
        this.FIO = FIO;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSkype() {
        return skype;
    }

    public void setSkype(String skype) {
        this.skype = skype;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatarPath(String avatar) {
        this.avatar = avatar;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getExperiences() {
        return experiences;
    }

    public void setExperiences(String experiences) {
        this.experiences = experiences;
    }

    public String getEducations() {
        return educations;
    }

    public void setEducations(String educations) {
        this.educations = educations;
    }

    public String getAdditionalEducations() {
        return additionalEducations;
    }

    public void setAdditionalEducations(String additionalEducations) {
        this.additionalEducations = additionalEducations;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }
}
