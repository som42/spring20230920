package com.example.spring20230920.controller;

import com.example.spring20230920.dao.MyDao7;
import com.example.spring20230920.domain.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
@RequestMapping("main37")
public class Controller37 {

    private final MyDao7 dao7;

    public Controller37(MyDao7 dao7) {
        this.dao7 = dao7;
    }

    // json 형식 문자열
    /*
    axios.post("/main37/sub1", '{"name" : "jones"}', {
        headers:{
            "content-type": "application/json"
                                이렇게 써야 json 인줄 안다.
        }
    })
    위랑 아래는 똑같은 일을 한다.
    자바 스크립트 객체 쓰면 똑같은 일 해서 상관없다.
    axios.post("/main37/sub1", {name: "jones"})
     */
    /*
    직렬화 serialize (객체를 텍스트(아닐수도 있다)로 변경)
    js(java) object -> json text

    파싱 parse (실제 객체로 변경한걸)
    json text -> js(java) object
     */
    @PostMapping("sub1")
    public void method1(@RequestBody Map<String, Object> map){
        System.out.println("map = " + map);
    }

    /*
    axios.post("/main37/sub2", {name: "lee", age:33, score: 8.9})
     */
    /*
    js object
    {name: "lee", age:33, score: 8.9}
    json text
    {"name": "lee", "age":33, "score": 8.9}
    -> 파싱
    java map
    {name: "lee", age:33, score: 8.9}
     */
    // 파싱 된거 받을려면 @RequestBody
    @PostMapping("sub2")
    public void method2(@RequestBody Map<String, Object> map){
        System.out.println("map = " + map);
    }

    // put 방식으로
    /*
    axios.put("/main37/sub3", {
        city: "seoul",
        name: "son",
        email: "son@naver.com"
        })
     */
    @PutMapping("sub3")
    public void method3(@RequestBody Map<String, Object> map){
        System.out.println("map = " + map);
    }

    // java 빈으로
    /*
  axios.post("/main37/sub4", {
        city: "paris",
        age: 30,
        married: true,
        car: null,
        home: {
            address: "seoul",
            price: 1000
        },
        foods: [
            "pizza",
            "burger",
            "부침개"
        ]
    })
     */
    @PostMapping("sub4")
    public void method4(@RequestBody MyDto42 dto){
        System.out.println("dto = " + dto);

    }
    /*
    axios.post("/main37/sub5",{
        country: "한국",
        score: 5,
        skills: ["달리기","엎어 치기","넘어 지기"],
        phone: "010-8888-2222"
 })
     */

    @PostMapping("sub5")
    public void method5(@RequestBody MyDto43 dto){
        System.out.println("dto.getCountry() = " + dto.getCountry());
        System.out.println("dto.getScore() = " + dto.getScore());
        System.out.println("dto.getSkills = " + dto.getSkills());
        System.out.println("dto.get = " + dto.getPhone());
    }
    /*
    axios.post("/main37/sub6", {
        name: "son",
        email: ["son@gmail.com", "hm@gmail.com"],
        home: {
            first: "seoul",
            second: "london"
        },
        price: 35.11,
        weight: 77.6,
        married: true
    })
     */

    @PostMapping("sub6")
    public void method6(@RequestBody MyDto44 dto){
        System.out.println("dto = " + dto);
    }

    /*
    axios.put("/main37/sub7", {
        id: 3,
        lastName: "kim",
        firstName: "minjag",
        birthDate: "1999-09-09"
    })
     */
    @PostMapping("sub7")
    public void method7(@RequestBody MyDto41 dto){
        int i  = dao7.updateEmployee(dto);
        System.out.println(dto.getId() + "번 직원 수정됨");
    }

    // Controller 에 요청오면 서비스에서 jSon식으로 주

}
