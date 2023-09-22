package com.example.spring20230920.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.lang.reflect.Member;

@Controller
@RequestMapping("main8")
public class Controller08 {

    @RequestMapping("sub1")
    public void method1(Model module){
        module.addAttribute("attr1","오늘은 날씨는");
        module.addAttribute("attr2","비가 안와서 너무아쉬워용");
        //forward to / WEB-INF/jsp/main8/sub1.jsp
    }

    @RequestMapping("sub2")
    public void method(Model model){
        model.addAttribute("propone","😶‍🌫️");
        model.addAttribute("propTWO","😌");
    }

    @RequestMapping("sub3")
    public void method3(Model model){
        //모델을 이용 해서 내용을 바꾸기
        // view name : /main8/sub3
        // /WEB-INF/jsp/main8/sub3.jsp
        model.addAttribute("maName","🍔햄버거");
        model.addAttribute("yourAddress","🥗샐러드");
        model.addAttribute("herEmail","🎂케이크");
    }


}
