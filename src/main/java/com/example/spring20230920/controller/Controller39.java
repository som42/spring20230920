package com.example.spring20230920.controller;

import com.example.spring20230920.dao.MyDao8;
import com.example.spring20230920.domain.MyDto33Employee;
import com.example.spring20230920.domain.MyDto45;
import com.example.spring20230920.service.MyService1;
import com.example.spring20230920.service.MyService2;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("main39")
public class Controller39 {

    private final MyDao8 dao;
    private final MyService2 service;

    @GetMapping("sub0")
    public void method0(){
    }

    // ResponseEntity
    // 200번이 아니면 전부 에러가 뜬다
    @GetMapping("sub1")
    @ResponseBody // ResponseEntity 이면 생략 가능
    public ResponseEntity method1() {
        //ResponseEntity
        // : 응답 코드, 응답 본문 작성 가능한 객체
        return ResponseEntity.status(200).build();
    }

    @GetMapping("sub2")
    @ResponseBody
    public ResponseEntity method2(){
        // notFound 404응답
//        return ResponseEntity.badRequest().build();
        return ResponseEntity.internalServerError().build();
    }

    @GetMapping("sub3")
    @ResponseBody
    public ResponseEntity method3(){
        // internalServerError 500 에러
        return ResponseEntity.internalServerError().build();
    }

    // 본문도 결정할수 있다
    // ResponseEntity 제네릭 타입 (타입 파라미터가 본문을 결정해준다)
    @GetMapping("sub4")
    public ResponseEntity<MyDto45> method4(Integer id){
        MyDto45 data = dao.selectProductById2(id);

        // 세개다 같은 일을 한다.
//        return ResponseEntity.status(200).body(data);
//        return ResponseEntity.ok().body(data);
//        return ResponseEntity.ok(data);
        if (data == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(data);
        }
    }
    // 성공, 실패 , 항상
    @GetMapping("sub5")
    public ResponseEntity method5(){
        if (Math.random() > 0.5 ){
            return ResponseEntity.ok().build(); //2xx
        }else {
            return ResponseEntity.internalServerError().build(); //5xx
        }
    }

    @PostMapping("sub6")
    public ResponseEntity method6(@RequestBody MyDto33Employee dto) {
        if (service.validate(dto)) {
            int rows = service.add(dto);
            System.out.println(rows);
            if (rows == 1){
                return ResponseEntity.ok().build();
            } else {
                return ResponseEntity.internalServerError().build();
            }
        } else {
            return ResponseEntity.badRequest().build();
        }
    }
}
