package com.example.spring20230920.domain;

import lombok.Data;

@Data // toString 해준다
public class MyDto19 {
    // java bean으로 해보기
    // 대소문자 구분없이 해준다.
    private Integer employeeId;
    private String lastName;
    private String firsName;
}
