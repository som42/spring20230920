package com.example.spring20230920;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class MyApp10 {

}

interface MyInterface1{


}
@Component
class MyClass18 implements MyInterface1{

}
@Component
class MyClass19 implements MyInterface1{

}
@Component
//@RequiredArgsConstructor
class MyClass17{
    private final MyInterface1 field;

    // 주입 될수 있는 빈이 여러개라면 @Qualirier라고 명시해주고 빈이름넣어줘야한다.
    public MyClass17(@Qualifier("myClass18") MyInterface1 field) {
        this.field = field;
    }
}
