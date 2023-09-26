package com.example.spring20230920.controller;

import com.example.spring20230920.domain.MyDto9;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("main11")
@Controller
public class Controller11 {
    @RequestMapping("sub1")
    public void method1(){

    }
    @RequestMapping("sub2")
    public void method2(){
    }

    @RequestMapping("sub3")
    public void method3(){

    }
    @RequestMapping({"sub4","sub5","sub6"})
    public void method4(){

    }

    @RequestMapping("sub7")
    public void method5(@RequestParam(value = "show", defaultValue = "false") Boolean show, Model model){
        if (show){
            List<MyDto9> list = new ArrayList<>();
            list.add(new MyDto9("31","son","hm","football","010"));
            list.add(new MyDto9("32","김","아리","부산","011"));
            list.add(new MyDto9("33","한","여름","제주","018"));
            list.add(new MyDto9("34","백","아침","경기","019"));
            list.add(new MyDto9("21","김","산","창원","010"));
            list.add(new MyDto9("22","영","달","진주","018"));

            model.addAttribute("moving",list);
        }

    }
}
