package com.example.spring20230920.controller;

import com.example.spring20230920.domain.MyDto10;
import com.example.spring20230920.domain.MyDto9;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
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

    @RequestMapping("sub6")
    public void method6(Model model){
        List<MyDto9> list = new ArrayList<>();
        list.add(new MyDto9("31","son","hm","football","010"));
        list.add(new MyDto9("32","김","아리","부산","011"));
        list.add(new MyDto9("33","한","여름","제주","018"));
        list.add(new MyDto9("34","백","아침","경기","019"));
        list.add(new MyDto9("21","김","산","창원","010"));
        list.add(new MyDto9("22","영","달","진주","018"));

        model.addAttribute("moving",list);
    }

    @RequestMapping("sub7")
    public void method7(Model model){
        model.addAttribute("a",3);
        model.addAttribute("b",5);

        //el은 +는 산술 연산 으로만 사용이 되기 때문에 "9", "8"도 더해서 17이 나온다.
        model.addAttribute("c","8");
        model.addAttribute("d","9");

    }

    @RequestMapping("sub8")
    public void method8(Model model){
        model.addAttribute("a",3);
        model.addAttribute("b",5);

        model.addAttribute("c","한여름");
        model.addAttribute("d","한겨울");

        model.addAttribute("e","11");
        model.addAttribute("f","2");
        model.addAttribute("g",2);
        //${e > f} : false
        //${e > g} : true 타입이 다르면 한쪽을 타입을 맞춰준다.
    }

    @RequestMapping("sub9")
    public void method9(Model model){
        model.addAttribute("a","java");
        model.addAttribute("b","");

        model.addAttribute("c",List.of(3,4));
        model.addAttribute("d",List.of());

        model.addAttribute("e",Map.of("name","son"));
        model.addAttribute("e",Map.of());

        model.addAttribute("g",null);
    }

}

