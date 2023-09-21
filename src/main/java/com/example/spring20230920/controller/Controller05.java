package com.example.spring20230920.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("main5")
public class Controller05 {

    // /main5/sub1?name=lee&age=33&address=paris
    // 꼭 이메서드가 있을때 일하게 할라면 params
    @RequestMapping(value = "sub1",params = {"address","age"})
    public void method1(String name, Integer age, String address){
        System.out.println("name = " + name);
        System.out.println("age = " + age);
        System.out.println("address = " + address);
    }

    // /main5/sub2?name=lee&age=44&address=paris
    @RequestMapping("sub2")
    public void method2(String name, Integer age, String address){
        Parson5 o1 = new Parson5(); //클래스 만든거 생성자 만들어주고
        o1.setName(name);
        o1.setAge(age);
        o1.setAddress(address);

        System.out.println("o1 = " + o1);

//        service.action(o1);
    }
    // /main5/sub3?name=lee&age=44&address=paris
    @RequestMapping("sub3")
    public void method3(Parson5 parson5){
        System.out.println("parson5 = " + parson5);
    }

    // /main5/sub4?email=ab@amail.com&married=true&age=33&info=programmer
    @RequestMapping("sub4")
    public void method4(Student5 student5){
        System.out.println("student5 = " + student5);
    }
}

class Student5{
    private String email;
    private Boolean married;
    private Integer age;
    private String info;

    @Override
    public String toString() {
        return "Student5{" +
                "email='" + email + '\'' +
                ", married=" + married +
                ", age=" + age +
                ", info='" + info + '\'' +
                '}';
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getMarried() {
        return married;
    }

    public void setMarried(Boolean married) {
        this.married = married;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getInformation() {
        return info;
    }

    public void setInformation(String info) {
        this.info = info;
    }
}

class Parson5{
    //get, set, 만들고 toString메서드 재정의해주고
   private String name;
   private Integer age;
   private String address;

    @Override
    public String toString() {
        return "Parson5{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
