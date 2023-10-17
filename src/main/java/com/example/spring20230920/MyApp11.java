package com.example.spring20230920;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

public class MyApp11 {
    public static void main(String[] args) {

    }
}

interface MyInterface2{
    public void method2();
}
class MyClass21 implements MyInterface2{
    @Override
    public void method2(){
    }
}
@Component
class MyClass22 implements MyInterface2{
    public void method2(){

    }
}
@Component
@RequiredArgsConstructor
class MyClass20 {
    // 인터페이스를 통해서 안전하게 작업을 할수 있다.
    private final MyInterface2 field;

    public void method20(){
        // 다형성 때문에 실제 인스턴스가 실행된다.
        field.method2();
    }
}
