package com.example.spring20230920;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class MyApp5 {
    public static void main(String[] args) {

      ApplicationContext context = SpringApplication.run(MyApp5.class, args);

      // 스프링 안쓰고 우리가 직접 제어 (control)
        MyClass8 obj8 = new MyClass8();
        MyClass7 obj7 = new MyClass7();
        obj7.setField1(obj8);

        obj7.method7();
    }
}

class MyClass8{
    public void method8(){
        System.out.println("MyClass8.method8");
    }

}

class MyClass7{
    // 만약 method8인스턴스를 사용한다면
    // 애가 있어야만 메소드를 잘 실행시킬수 있다.
    private MyClass8 field1; // dependency (의존성)

    public MyClass7(){}
    public MyClass7(MyClass8 field1) {
        this.field1 = field1;
    }
    //set 메소드 할대 setf하면 바로됨
    public void setField1(MyClass8 field1) {
        this.field1 = field1;
    }

    public void method7(){
        field1.method8(); // 8이라는 메소드를 실행한다면
    }
}
