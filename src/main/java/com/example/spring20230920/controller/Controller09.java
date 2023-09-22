package com.example.spring20230920.controller;
import com.example.spring20230920.domain.MyDto7;
import com.example.spring20230920.domain.MyDto8;
import com.example.spring20230920.domain.MyDto9;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

@Controller
@RequestMapping("main9")
public class Controller09 {
    @RequestMapping("sub1")
    public void method1(Model model){
        model.addAttribute("attr1","son");
        model.addAttribute("attr2",300);
        model.addAttribute("attr3",true);
        model.addAttribute("attr4",3.14);

        //모델 속성이 배열일 경우
        model.addAttribute("attr5", new String[]{"lee","kim"});

        String[] myArr1 = {"korea","seoul","jeju"};
        model.addAttribute("yourArr6",myArr1);

    }

    @RequestMapping("sub2")
    public void method2(Model model){
//        String[] a1 = {"한여름","한겨울","한가을"};
//        model.addAttribute("myName",a1);
        model.addAttribute("myName",new String[]{"한여름","한겨울","한봄"});

        String[] a2 = {"zzzoo42@naver.com","dkxhaektha@naver.com","zzz42@naver.com"};
        model.addAttribute("yourEmail",a2);

        String[] a3 = {"배고팡"};
        model.addAttribute("herAddress",a3);

    }
    @RequestMapping("sub3")
    public void method3(Model model){
        model.addAttribute("names", List.of("두식","봉석","희수"));
        //List도 배열처럼 쓰면된다

        model.addAttribute("list1",List.of("🎂","😊","🍔"));
        model.addAttribute("mapList1",List.of("🥐","🥨","🥖"));
        model.addAttribute("cities",List.of("👍","❤️","😊","😌"));

//        var List1 = List.of("df""df");
//        model.addAttribute("adf",List1); 이런방법도 있다.
    }

    @RequestMapping("sub4")
    public void method4(Model model){
        var map1 = Map.of("son",7,"lee",19,"kim",30);

        model.addAttribute("myMap",map1);

        var map2 = Map.of("seoul","😊","busan","😌");
        var map3 = Map.of("red","빨강","blue","파랑","black","블랙");

        model.addAttribute("cityMap",map2);
        model.addAttribute("color",map3);

        var map = Map.of(
                "name","두식",
                "my name", "봉석",
                "your-name","희수"
                );
        model.addAttribute("attr3",map);
    }

    @RequestMapping("sub5")
    public void method5(Model model){
        var map1 = Map.of("phone1","iphone","phone2","galexy");
        var map2 = Map.of("korea","seoul","us","ny");
        var map3 = Map.of("1st","hamburger","2nd","pizza");


        model.addAttribute("korea","us");
        model.addAttribute("phones",map1);
        model.addAttribute("caps",map2);
        model.addAttribute("foods",map3);
    }

    @RequestMapping("sub6")
    public void method6(Model model){
        model.addAttribute("attr1",new Object());
        model.addAttribute("attr2",new Scanner(System.in));
        model.addAttribute("attr3",new MyDto7());

    }

    @RequestMapping("sub7")
    public void methode7(Model model){
        MyDto8 o1 = new MyDto8();
        o1.setFood("pizza❤️");
        o1.setComputer("intel🌭");
        o1.setBirthDate("2020-01-01🥪");

        model.addAttribute("person1",o1);

    }

    @RequestMapping("sub8")
    public void methode8(Model model){
        MyDto9 o1 = new MyDto9();
        o1.setId("zzzoo42🥞");
        o1.setFirstName("김아리");
        o1.setLastName("밍쓴");
        o1.setClassName("도화가");
        o1.setPhoneNumber("안알려줌");

        model.addAttribute("student",o1);

    }

}

