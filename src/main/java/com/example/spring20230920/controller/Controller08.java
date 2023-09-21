package com.example.spring20230920.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
