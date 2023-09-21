package com.example.spring20230920.domain;

public class MyDto1 {
    // property 명 : get/set 없애고 소문자로 시작
    // name property
    // HomeAddress 아니고 homeAddress이다
    private String name;
    private String homeAddress;
    private String MYHOME;
    private Boolean married; //불리언타입일때

    //is 는 get만된다.
    public Boolean isMarried() {  // getMarried도 되고 isMarried도된다 Boolean타입일때
        return married;
    }

    public void setMarried(Boolean married) {
        this.married = married;
    }

    public String getMYHOME() { //대문자가 연속으로 있으면 property이다
        return MYHOME;
    }

    public void setMYHOME(String MYHOME) {
        this.MYHOME = MYHOME;
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
