package com.example.spring20230920.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("main4")
public class Controller04 {

    // /main4/sub1?name=son
    // requset parameter 의 이름과 method parameter 의 이름이 같으면
    // @RequestParam의 value element 생략 가능
    @RequestMapping("sub1")
    public void method1(@RequestParam String name){
          // (@RequestParam("name") String name) 높은확률로 파라미터랑 이름이 같아서 안써줘도된다.
        System.out.println("name = " + name);
    }

    // /main4/sub2?address=soul&email=abc@gmail.com&age=44
    @RequestMapping("sub2")
    public void method2(@RequestParam String address,
                        @RequestParam String email,
                        @RequestParam Integer age){
        System.out.println("address = " + address);
        System.out.println("email = " + email);
        System.out.println("age = " + age);
    }

    // /main4/sub3?name=son&married=true
    @RequestMapping("sub3")
    public void method3(String name, Boolean married){
        //@RequestParam도 생략이 가능하다.
        System.out.println("name = " + name);
        System.out.println("married = " + married);
    }

    // /main4/sub4?check=true&email=abc@naver.com&age=55
    @RequestMapping("sub4")
    public void method4(Boolean check, String email, Integer age){
        System.out.printf("check = %s%nemail = %s%nage = %s%n", check, email, age);
//        System.out.println("check = " + check);
//        System.out.println("email = " + email);
//        System.out.println("age = " + age);
    }
}
