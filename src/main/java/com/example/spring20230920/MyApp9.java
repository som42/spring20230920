package com.example.spring20230920;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class MyApp9 {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(MyApp9.class, args);
        MyClass16 myClass16 = context.getBean("myClass16", MyClass16.class);
        MyClass15 myClass15 = context.getBean("myClass15", MyClass15.class);

        System.out.println("myClass16 = " + myClass16);
        System.out.println("myClass15 = " + myClass15.getField());
    }
}
@Component
class MyClass16{

}
@Component
@RequiredArgsConstructor // fianl 필드를 아규먼트로 받는 생성자 만들어주는 lombok annotat.
class MyClass15 {
    // field final이면 값을 꼭 한번은 받아야 한다.
    // 그게 생성자에서 받아야 한다
    private final MyClass16 field;


    public MyClass16 getField() {
        return field;
    }
}
