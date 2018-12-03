package com.simbirsoft.javacourse.controller;

import com.simbirsoft.javacourse.entity.PersonalData;
import com.simbirsoft.javacourse.service.SummaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class AppController {

    @Autowired
    private SummaryService service;



    @GetMapping("/view_resume")
    public String viewResumeById(Model model){//, @RequestParam(value = "pass", required = false) Long id){

        long id = 1;

        List <PersonalData> list = service.getPersonById(id);


        System.out.println(list.get(0).getFIO());


        model.addAttribute("Person",list.get(0));
        return "resume";
    }

    @GetMapping("/test")
    public String getPersonInfo(Model model){

        List<PersonalData> list = service.getAll();

        if (list == null) {
            model.addAttribute("message", "Employee is empty");
            return "message";
        }

        model.addAttribute("Persons",list);

        return "test";
    }

    @GetMapping("/res")
    public String addPerson(Model model){
        model.addAttribute("Person",new PersonalData());
        return "addResume";
    }

    @GetMapping("/add")
    public String addPersonFromProperty(Model model, @RequestParam(value = "pass", required = false) String pass){

        PersonalData person = service.getData(pass);
        if(person == null){
            model.addAttribute("message", "Employee is empty");
            return "message";
        }


        service.addPerson(person);
        return "message";
    }

    @PostMapping("savePerson")
    public String save(@ModelAttribute PersonalData person) {
        service.addPerson(person);
        return "redirect:res";
    }
}
