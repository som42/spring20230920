package com.example.spring20230920.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;

//Query String
@Controller
@RequestMapping("/main2")
public class Controller03 {

    // /main2/sub1?address=seoul
    @RequestMapping("/sub1")
    public void method1(WebRequest request){
        System.out.println("Controller03.method1");

        String address = request.getParameter("address");
        System.out.println("address = " + address);
    }

    // /main2/sub2?name=son&address=london
    @RequestMapping("/sub2")
    public void method2(WebRequest request){
        String name = request.getParameter("name");
        String address = request.getParameter("address");

        System.out.println("name = " + name);
        System.out.println("address = " + address);
    }


    //main2/sub3?name=손흥민
    @RequestMapping("/sub3")
    public void method3(@RequestParam("name")String name){
                     //따로 안빼고 파라미터로 네임을 넣어라 해줘도된다
        System.out.println("name = " + name);

    }

    // /main2/sub4?name=김도식&address=서울
    //적을때  @RequestMapping 이랑 @RequestParam 헷갈리지말것
    @RequestMapping("/sub4")
    public void method3(@RequestParam("name") String name,
                        @RequestParam("address")String address){
        System.out.println("name = " + name);
        System.out.println("address = " + address);
    }

    // /main2/sub5?email=abc@gmail.com&gender=남자&number=010-999
    @RequestMapping("sub5")
    public void method5(@RequestParam("email") String email,
                        @RequestParam("gender") String gender,
                        @RequestParam("number") String number){
        System.out.println("email = " + email);
        System.out.println("gender = " + gender);
        System.out.println("number = " + number);
    }

    @RequestMapping("sub6")
    public void method6(@RequestParam("name") String name,
                        @RequestParam("age") String age){
        System.out.println("name = " + name);
        System.out.println("age = " + age);

        Integer a = Integer.valueOf(age);
    }

    // /main2/sub7?name=손&age=50
    //숫자 넣을때 바로 그냥 Integer넣어두된다.
    @RequestMapping("sub7")
    public void method7(@RequestParam("name") String name,
                        @RequestParam("age") Integer age){
        System.out.println("name = " + name);
        System.out.println("age = " + age);
    }

    // /main2/sub8?address=seoul&married=false&age=66
    @RequestMapping("sub8")
    public void method8(@RequestParam("address") String address,
                        @RequestParam("married") Boolean married,
                        @RequestParam("age") Integer age){
        System.out.println("address = " + address);
        System.out.println("married = " + married);
        System.out.println("age = " + age);
    }

    // /main2/sub?name=son
    @RequestMapping("sub9")
    public void method9(@RequestParam(value = "name", required = false) String name){
        //값을 적지 않아도 메소드가 일하게 하고싶을때는 required = false 써주면된다.
        System.out.println("name = " + name);
    }

    // /main2/sub10?address=seoul&age=30
    // /main2/sub10?address=jeju
    @RequestMapping("sub10")
    public void method10(@RequestParam("address") String address,
                         @RequestParam(value = "age",required = false) Integer age){
        System.out.println("address = " + address);
        System.out.println("age = " + age);
    }

    // /main2/sub11
    @RequestMapping("sub11")
    public void method11(@RequestParam(value = "age",defaultValue = "0") Integer age){
          //age에 값을넣지않아도  아무것도 안적어도 메소드는 일한다.
        System.out.println("age = " + age);
    }
}
