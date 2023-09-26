package com.example.spring20230920.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("main15")
public class Controller15 {

    @GetMapping("sub1")
    public void method1(){

    }

    //세션을 받고 싶으면 이렇게하면됨 HttpSession session
    @GetMapping("sub2")
    public void method2(
            HttpServletRequest request,  //사용자 정보
            HttpSession session   // 세션
            //세션 객체를 스프링 으로 받는다.
            //같은 브라우저 에 온 세션은 저장 해놓은 정보를 바로 꺼낼수 있다.
            //모델에 저장하는 어튜리뷰트
    ){
        System.out.println();
        System.out.println("request.getRemoteHost() = " + request.getRemoteHost());
        System.out.println("session.getId() = " + session.getId());
        System.out.println();
    }

    @GetMapping("sub3")
    public void method3(
            @RequestParam(value = "name",defaultValue = "") String name,
            HttpSession session,
            HttpServletRequest request
            ){
        if (!name.isBlank()){
            session.setAttribute("username",name);
        }
        Object username = session.getAttribute("username");

        if (username != null){
            System.out.println();
            System.out.println("request = " + request.getRemoteHost());
            System.out.println("username = " + username);
            System.out.println();
        }
    }
}
