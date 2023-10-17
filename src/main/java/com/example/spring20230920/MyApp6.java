package com.example.spring20230920;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class MyApp6 {
    //스프링 도움 받아서 해보기
    public static void main(String[] args) {
        // Inversion of Control (IOC)
        // IOC Container
        ConfigurableApplicationContext context = SpringApplication.run(MyApp6.class, args);

        MyClass9 myClass9 = context.getBean("myClass9",MyClass9.class);
        myClass9.method9();

        System.out.println("myClass9.getField1() = " + myClass9.getField1());

        Object myClass10 = context.getBean("myClass10");
        System.out.println("myClass10 = " + myClass10);

    }
}

@Component
class MyClass10{
    public void method10(){
        System.out.println("MyClass10.method10");
    }

}
@Component
class MyClass9{ // myClass9
    private MyClass10 field1; // dependency

    // 생성자, set 메소드가 있어야 한다.
    public MyClass9(){} // set메소드 쓸려고 기본생성자
    public MyClass9(MyClass10 field1) {
        this.field1 = field1;
    }

    // 이 필드에 값을 좀 넣어달라 (set 메소드에)
    @Autowired // dependency injection ( DI 의존성 주입)
    public void setField1(MyClass10 field1) {
        this.field1 = field1;
    }

    public MyClass10 getField1() {
        return field1;
    }

    public void method9(){
        field1.method10();
    }
}
