package com.example.spring20230920.domain;

import lombok.Data;

import java.util.List;

@Data
public class MyDto10 {
    private String name;
    private Integer id;
    private List<String> foods; //푸드의 프러퍼티가 리스트
    private List<String> cars;
}
