package com.example.spring20230920.controller;

import com.example.spring20230920.dao.MyDao3;
import com.example.spring20230920.domain.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.DoublePredicate;

@Controller
@RequiredArgsConstructor
@RequestMapping("main29")
public class Controller29 {

    private final MyDao3 dao3;

    // 하나행 하나열
    @GetMapping("sub1")
    public void method1() {
        String name = dao3.select1();
        System.out.println("name = " + name);
    }

    @GetMapping("sub2")
    private void method2(){
        Double price = dao3.select2();
        System.out.println("price = " + price);
    }

    @GetMapping("sub3")
    public void method3(){
        //1번 직원의 LastName 조회 후 출력
        String s = dao3.select3();
        System.out.println("s = " + s);
    }

    @GetMapping("sub4")
    public void method4(){
        // 2번 직원의 생일 조회 후 출력
        LocalDate i = dao3.select4();
        System.out.println("i = " + i);
    }
    // 여러행 , 하나열
    @GetMapping("sub5")
    public void method5(){
      List<String> countrys = dao3.select5();

      countrys.forEach(System.out::println);
    }

    @GetMapping("sub6")
    public void method6(){
        // 직원들의 생일 조회
      List<String> births = dao3.select6();
        System.out.println("births.size() = " + births.size());
    }

    @GetMapping("sub7")
    private void method7(){
        // 상품의 가격들 조회
        List<Double> priceList = dao3.select7();
        System.out.println("priceList.size() = " + priceList.size());
    }

    // 행은 1개 여러 개 열
    @GetMapping("sub8")
    public void method8(){
        Map<String, Object> row = dao3.select8();
        System.out.println("row = " + row);
    }

    @GetMapping("sub9")
    public void method9(){
        // 1번 상품의 상품명, 가격, 카테고리명
        Map<String, Object> sel = dao3.select9();
        sel.entrySet().forEach(System.out::println);
        System.out.println("sel = " + sel);
    }

    // 자바 빈 GET, SET,

    @GetMapping("sub10")
    public void method10(){
        MyDto19 dto = dao3.select10();
        System.out.println("dto = " + dto);
    }

    @GetMapping("sub11")
    public void method11(){
        MyDto20 dto = dao3.select11();
        System.out.println("dto = " + dto);
    }

    @GetMapping("sub12")
    public void method12(){
        MyDto21 dto = dao3.select12();
        // 2번 고객의 id, name, country
        //MyDto21의 property (id, name, country)
        System.out.println("dto = " + dto);
    }

    // 여러 열 여러 행
    // list 와 Map을 같이 사용해준다.
    @GetMapping("sub13")
    public void method13(){
        List<Map<String,Object>> rows = dao3.select13();
        for (Map<String, Object> row : rows) {
            System.out.println("row = " + row);
        }
    }

    @GetMapping("sub14")
    public void method14(){
        // 1996년 7월 4일에 주문된 상품명, 상품 수량, 상품의 가격
        List<Map<String,Object>> rows = dao3.select14();
        rows.forEach(System.out::println);
//        for(Map<String,Object> row : rows){
//            System.out.println("row = " + row);
//        }

    }
    // map 말고 자바 빈으로 해보기
    @GetMapping("sub15")
    public void method15(){
        // 1996년 7월 4일에 주문된 상품명, 상품 수량, 상품의 가격
        List<MyDto22> rows = dao3.select15();
        rows.forEach(System.out::println);
    }

    //sub16 요청시
    // 1번 카테고리 상품들이 주문된 날짜, 상품명, 카테고리명, 수량, 가격
    // 날짜, 상품명 순으로 정렬
    @GetMapping("sub16")
    public void method16(){
        List<MyDto23> rows = dao3.select16();
        rows.forEach(System.out::println);
        System.out.println("rows.size() = " + rows.size());
    }

    // 100번재 고객이 없다면 null로 넘어간다
    @GetMapping("sub17")
    public void method17(){
        String s = dao3.select17();
        System.out.println("s = " + s);
    }
    //런타임 인셉션 주기 싫으면 참조 타입으로 타입을 정해주는게 좋다.
    // 래퍼 클래스를 주로 쓰면 좋다.
    @GetMapping("sub18")
    public void method18(){
        Integer s = dao3.select18();
        System.out.println("s = " + s);
    }

    // 프로 퍼티를 일치하지 않게 쓰면 내용이 들어 가지 않고 null로 남아있다.
    // 빈에 프로퍼티 명과, 쿼리에 조회된 컬럼명이 다르면 내용이 들어가지 않는다
    @GetMapping("sub19")
    public void method19(){
        MyDto24 dto = dao3.select19();
        System.out.println("dto = " + dto);
    }

    @GetMapping("sub20")
    public void mtehod20(){
        MyDto24 myDto24 = dao3.select20();
        System.out.println("myDto24 = " + myDto24);
    }


}
