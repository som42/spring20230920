package com.example.spring20230920.domain;

import lombok.Data;

@Data
public class MyDto35 {
    private String id;

    // 프로퍼티 명 : id
    // get을 빼고 나머지 글자에서 앞글자 소문자가 프로퍼티명
    public String getId() {
        return id;
    }

    private String uRL;
    // 앞글자가 소문자로 되어 있더라도
    // get에서는 URL로 되어있다
    // 그래서 프로 퍼티 명은 url; 이다
    private String getURL(){
        return id;
    }

}
