package com.example.spring20230920;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

@SpringBootApplication // 스프링부트 불러오기
public class MyApp2 {
    public static void main(String[] args) {
        // 스프링부터 어플리케이션 실행 시키는 방법
        // 이렇게 필요한 인스턴스를 필요한 클래스를 자동으로 만든다.
        // 객체를 만드는 일을 스프링이 했다
        // 스프링이 만든 인스턴스를 스프링 빈 이라고 한다.
        ApplicationContext context = SpringApplication.run(MyApp2.class, args);
        Object bean1 = context.getBean("myInstance2"); // spring bean
        System.out.println(bean1 instanceof MyClass2); // true
        MyClass2 o1 = (MyClass2) bean1;
        o1.method2();

        Object bean3 = context.getBean("myBean3"); // spring bean
        System.out.println(bean3 instanceof MyClass3); // true
        MyClass3 o3 = (MyClass3) bean3;

        System.out.println(System.identityHashCode(context.getBean("myBean3")));
        System.out.println(System.identityHashCode(context.getBean("myBean3")));
        System.out.println(System.identityHashCode(context.getBean("myBean3")));

        System.out.println(System.identityHashCode(context.getBean("myInstance2")));
        System.out.println(System.identityHashCode(context.getBean("myInstance2")));
        System.out.println(System.identityHashCode(context.getBean("myInstance2")));

        // 형변환 자동 메소드
        MyClass2 bean22 = context.getBean("myInstance2", MyClass2.class);
        MyClass3 bean33 = context.getBean("myBean3", MyClass3.class);

        System.out.println(System.identityHashCode(bean22));
        System.out.println(System.identityHashCode(bean33));
    }
}
@Component("myBean3")
class MyClass3{

}
@Component("myInstance2") // 이 클래스로 인스턴스를 스프링부트가 만들어줌
class MyClass2 {
    public void method2(){
        System.out.println("MyClass2.method2");
    }
}
