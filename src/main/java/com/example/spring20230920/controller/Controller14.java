package com.example.spring20230920.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("main14")
//별일없으면 Get매핑, post매핑으로 해주는게 좋다
public class Controller14 {
    @GetMapping({
            "sub1",
            "sub3"})
    public void method1(){}

//    @RequestMapping(value = "sub2", method = RequestMethod.GET)
    @GetMapping("sub2")
    public void method2(
            @RequestParam("id") String id,
            @RequestParam("password") String password
    ){
        System.out.println("Controller14.method2");

        System.out.println("id = " + id);
        System.out.println("password = " + password);
    }
//    @RequestMapping(value = "sub2",method = RequestMethod.POST)
    @PostMapping("sub2")
    public void method3(
            @RequestParam("id") String id,
            @RequestParam("password") String password
    ){
        System.out.println("id = " + id);
        System.out.println("password = " + password);
    }

//    @RequestMapping(value = "sub4", method = RequestMethod.POST)
    @PostMapping("sub4")
    public void method4(
            String title,
            String content
    ) {
        System.out.println("title = " + title);
        System.out.println("content = " + content);
    }

//    @RequestMapping(value = "sub5", method = RequestMethod.GET)
    @GetMapping("sub5")
    public void method5(){

    }
//    @RequestMapping(value = "sub6",method = RequestMethod.POST)
    @PostMapping("sub6")
    public void method6(
            String username,
            String password

    ){
        System.out.println("username = " + username);
        System.out.println("password = " + password);
    }
}
