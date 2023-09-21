package com.example.spring20230920.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/main1") //이렇게 위로 빼주면된다. 앞에 /한개는 없앨수있다.
public class Controller02 {
    //경로가 흘러갔을때 앞부분이 같은 경로는 클래스로 뺄수있다.
    @RequestMapping("/sub1") //경로 안에 경로
    public void method1(){
        System.out.println("Controller02.method1");
    }

    //main1/sub2 메소드 작성
    @RequestMapping("/sub2")
    public void method2(){
        System.out.println("Controller02.method2");
    }

    @RequestMapping("/sub3")
    public void method3(){
        System.out.println("Controller02.method3");
    }
}
