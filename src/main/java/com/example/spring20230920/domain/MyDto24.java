package com.example.spring20230920.domain;

import lombok.Data;

@Data
public class MyDto24 {
    // 프로 퍼티를 일치하지 않게 쓰면 내용이 들어 가지 않고 null로 남아있다.
    // 빈에 프로퍼티 명과, 쿼리에 조회된 컬럼명이 다르면 내용이 들어가지 않는다
    private Integer id;
    private String name;
    private String country;
}
