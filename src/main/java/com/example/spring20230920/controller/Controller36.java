package com.example.spring20230920.controller;

import com.example.spring20230920.dao.MyDao7;
import com.example.spring20230920.domain.MyDto39;
import com.example.spring20230920.domain.MyDto40;
import com.example.spring20230920.domain.MyDto41;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Map;
import java.util.Objects;

@Controller
@RequestMapping("main36")
@RequiredArgsConstructor
public class Controller36 {
    // Axios
    private final MyDao7 dao;
    @GetMapping("sub1")
    public void method1(){

    }

    //axios.get("/main36/sub2",{params: {id,: 5}})

    // /main36/sub2?id=5
    @GetMapping("sub2")
    public void method2(Integer id){
        Map<String, Objects> data = dao.selectByCustomerId(id);
        System.out.println("data = " + data);
    }
    //js 코드? : axios.get("/main36/sub3". {params: {id, 2}})
    //main36/sub3?id=2
    @GetMapping("sub3")
    public void method3(Integer id){
        Map<String, Objects> data = dao.selectByEmployeeId(id);
        System.out.println("data = " + data);
    }
    /*
    axios.post("/main36/sub4", {
        lastName: "손",
        firstName: "흥민",
        birthDate: "2020-02-02"
        }, {
       headers: {
            "content-type": "application/x-www-form-urlencoded"
            }
        })
     */
    // post / main36/sub4
    // lastName=손&firstName=흥민&birthDate=2020-02-02
    @PostMapping("sub4")
    public void method4(String lastName,
                        String firstName,
                        LocalDate brithDate){
        dao.inserEmployee(lastName,firstName,brithDate);
    }

    //브라우저 개발자도구 콘솔에 axios코드 작성 후 실행
    /*
    axios.post("/main36/sub5",{
            name:"라면",
            price:150.00,
            category:3
         }, {
              headers: {
            "content-type": "application/x-www-form-urlencoded"
            }
        })
     */
    // post /main36/sub5
    // name=라면&price=150.00&category=3
    @PostMapping("sub5")
    public void method5(String name,
                        Double price,
                        Integer category){
        int r = dao.inserProduct(name, price, category);
    }
    /*
    axios.delete("/main36/sub6")
     */
    // DELETE 요청이 오면 sub6으로 간다.
//    @RequestMapping(method = RequestMethod.DELETE, value = "sub6")
    @DeleteMapping("sub6") // 위에 주석처리한 아이와 같은 일을 한다.
    public void method6(){
        System.out.println("Controller36.method6");
    }

    /*
    js 코드 작성후 브라우저 콘솔에 실행
    axios.delete("/main36/sub7")
     */
    @DeleteMapping("sub7")
    public void method7(){
        System.out.println("Controller36.method7");
    }

    /*
    axios.delete("/main36/sub8?name=son")
     */
    @DeleteMapping("sub8")
    public void method8(String name){
        System.out.println("name = " + name);
    }

    // 요청 보낼때 데이트를 같이 보내는 방법
    // pathVariable : 경로에 포함된 데이터
    /*
    axios.delete("/main36/sub9/son")
    axios.delete("/main36/sub9/lee")
     */
    // 세개다 이름이 같다면 @PathVariable("name") 이겨 ()는 생랴갷도된다
    @DeleteMapping("sub9/{name}")
    public void method9(@PathVariable String name){
        System.out.println("n = " + name);
    }

    /*
    axios.delete("/main36/sub10/3")
    axios.delete("/main36/sub10/5")
    axios.delete("/main36/sub10/7")
     */
    // delete/ main36/sub10
    // 일하는 메소드 작성
    // 3, 5, 7은 메소드 아규먼트로 받아서 콘솔에 출력
    @DeleteMapping("sub10/{age}")
    public void method10(@PathVariable("age") Integer i){
        System.out.println("i = " + i);
    }

    /*
    axios.delete("/main36/sub11/1")
    axios.delete("/main36/sub11/3")
    axios.delete("/main36/sub11/5")
     */
    @DeleteMapping("sub11/{pid}")
    public void method11(@PathVariable Integer pid){
       int c = dao.deleteByProductId(pid);
        System.out.println(c +"개 삭제 되었습니다 ");
    }
    /*
    axios.delete("/main36/sub12/1")
    axios.delete("/main36/sub12/3")
    axios.delete("/main36/sub12/5")
     */
    @DeleteMapping("sub12/{pid}")
    public void method12(@PathVariable Integer pid){
        int i = dao.deleteByCustomerId(pid);
        System.out.println( i + "개 삭제 되었습니다");
    }

// put( update 할때 주로 사용된다)
    /*
    axios.put("/main36/sub13")
     */
//    @RequestMapping(method = RequestMethod.PUT, value = "sub13")
    @PutMapping("sub13") // 위에쓴거랑 밑에쓴게 똑같다.
    public void method13(){
        System.out.println("Controller36.method13");
    }
    // 데이터를 보낼때는?
    /*
    axios.put("/main36/sub14",{
        name: "son",
        address: "korea"
     }, {
        headers: {
            "content-type" : "application/x-www-form-urlencoded"
        }
     })
     */
    // put 방식으로 /main36/sub14
    // name=son&address=korea
    @PutMapping("sub14")
    public void method14(String name, String address){
        System.out.println("name = " + name);
        System.out.println("address = " + address);
    }

    /*
    axios.put("/main36/sub15", {
        city: "seoul",
        age: 78,
        score: 3.14
    }, {
         headers: {
            "content-type" : "application/x-www-form-urlencoded"
        }
    });
     */
    @PutMapping("sub15")
    public void method15(MyDto39 dto){
        System.out.println("city = " + dto.getCity());
        System.out.println("age = " + dto.getAge());
        System.out.println("score = " + dto.getScore());
    }
    /*
    axios.put("/main36/sub16",{
        id: 3,
        name: "햄버거",
        category: 2,
        price: 5000.00
   }, {
         headers: {
            "content-type" : "application/x-www-form-urlencoded"
        }
    });

     */
    @PutMapping("sub16")
    public void method16(MyDto40 dto){
        int rows = dao.updateProduct(dto);
        System.out.println(rows + "개 데이터 수정됨");
    }

    /*
    axios.put("/main36/sub17", {
        lastName: "lee",
        firstName: "kangin",
        birthDate: "2020-01-01",
        id : 5
    }, {
         headers: {
            "content-type" : "application/x-www-form-urlencoded"
        }
    });
     */
    @PutMapping("sub17")
    public void method17(MyDto41 dto){
        int rows = dao.updateEmployee(dto);
        System.out.println(rows + "개 수정됨");
    }
}
