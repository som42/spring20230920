package com.example.spring20230920;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class MyApp7 {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(MyApp7.class, args);
        System.out.println(context.getBean("myClass12"));
        System.out.println(context.getBean("myClass11",MyClass11.class).getDep());
    }
}
@Component
class MyClass12{

}
@Component
class MyClass11{
    private MyClass12 dep;

    public MyClass11(){
    }
    // 생성자가 하나고 , 이생성자 뿐이 못쓰면 Autowired 생략 가능
    @Autowired // 생성자 주입
    public MyClass11(MyClass12 dep) {
        this.dep = dep;
    }

    public MyClass12 getDep() {
        return dep;
    }
}