package com.example.spring20230920.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller //붙여줘야 스프링이 애가 Controller인줄 안다!
public class Controller01 {
    @RequestMapping("/") // RequestMapping 를 붙이고 경로를 지정해주면 일한다.
    public void method1(){
        System.out.println("Controller01.method1");

    }
    @RequestMapping("/path1") //
    public void method2(){
        System.out.println("Controller01.method2");
    }

    // /path2로 요청 왔을 때 일하는 메소드 작성

    @RequestMapping("/path2")
    public void method3() {
        System.out.println("안뇽!");

    }

    @RequestMapping("path5")  // /는 생략가능
    public void method5(){
        System.out.println("Controller01.method5");
    }


}
