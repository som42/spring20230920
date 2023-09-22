package com.example.spring20230920.controller;

import com.example.spring20230920.domain.MyDto10;
import com.example.spring20230920.domain.MyDto9;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("main10")
public class Controller10 {
    @RequestMapping("sub1")
    public void method1(Model model){
        //객체 만들어서 List로 배열 만들어보기
        MyDto9 o1 = new MyDto9();
        MyDto9 o2 = new MyDto9();
        MyDto9 o3 = new MyDto9();
        MyDto9 o4 = new MyDto9();
        MyDto9 o5 = new MyDto9();

        o1.setFirstName("아리");
        o2.setFirstName("리아");
        o3.setFirstName("🌭🌭🌭");
        o4.setFirstName("🥪🥪🥪");
        o5.setFirstName("🥞🥞🥞");

        model.addAttribute("students", List.of(o1,o2));
        model.addAttribute("studentList",List.of(o3,o4,o5));
    }

    @RequestMapping("sub2")
    public void method2(Model model){
        MyDto9 o1 = new MyDto9();
        MyDto9 o2 = new MyDto9();

        o1.setLastName("아리");
        o2.setLastName("밍이");

        model.addAttribute("personMap",
                Map.of("person1", o1,"person2",o2));

        model.addAttribute("people",
                Map.of("1st",o1,"2nd",o2));
    }

    @RequestMapping("sub3")
    public void method3(Model model){
        MyDto10 o1 = new MyDto10();
        o1.setName("리아");
        o1.setId(5);
        o1.setFoods(List.of("pizza","burger","milk"));
        o1.setCars(List.of("디보","포르쉐","부가티"));

        model.addAttribute("person1",o1);

    }

    @RequestMapping("sub4")
    public void  method4(Model model){
        model.addAttribute("myList",List.of("디보","부가티","포르쉐"));

    }
    @RequestMapping("sub5")
    public void method5(Model model){
        model.addAttribute("foodList",List.of("🍪","🌮","🧇","🥪"));
        model.addAttribute("names", List.of("두식", "봉석", "희수", "미현"));
    }

}

