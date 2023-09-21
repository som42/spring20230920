package com.example.spring20230920.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("main7")
public class Controller07 {

    //(RequestMapping) Handler Method
    @RequestMapping("sub1")
    public String  method1(){
        System.out.println("Controller07.method1");

        return "view1";
        // 리턴된 스트링이 뷰의 이름이된다
    }

    @RequestMapping("sub2")
    public String method2(){
        System.out.println("Controller07.method2");

        return "html2"; // 뷰에이름으로 판단한다 스트링이
               //WEB-INF/jsp/html2.jsp
        //요청경로가 뷰에이름이 된다
    }

    //void return : 요청경로가 view name이 됨
    //요청 경로 :  /main7/sub3
    // view name : / main7/sub3
    // 실제 jsp 경로 : /WEB_INF/jsp/main7/sub3.jsp
    @RequestMapping("sub3")
    public void Method3(){  //void 리턴이 필요없다잉~
        System.out.println("Controller07.Method3");
    }

    @RequestMapping("sub4")
    public String method4(){

        return "/main7/html4";
    }

    ///WEB_INF/jsp/main7/sub5.jsp
    @RequestMapping("sub5")
    public void method5(){
        System.out.println("Controller07.method5");

    }
}
