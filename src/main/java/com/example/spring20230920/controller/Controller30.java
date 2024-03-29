package com.example.spring20230920.controller;

import com.example.spring20230920.dao.MyDao4;
import com.example.spring20230920.domain.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("main30")
@RequiredArgsConstructor
public class Controller30 {

    private final MyDao4 dao;

    @GetMapping("sub1")
    // id는 주소 적을때 ?id=1 이런식으로 적는다
    public void method1(Integer id) {
        String name = dao.select1(id);
        System.out.println("name = " + name);
    }

    //두개의 파라미터를 받게했다
    @GetMapping("sub2")
    public void method2(Double from, Double to){
        List<String> names = dao.select2(from,to);
        names.forEach(System.out::println);
    }

    @GetMapping("sub3")
    public void method3(LocalDate from, LocalDate to){
        // from~to 에 주문된 상품명 출력 (정렬해서, 중복없이)
        List<String> list = dao.select3(from, to);
        list.forEach(System.out::println);
        System.out.println("list.size() = " + list.size());
    }

    // /main30/sub4?min=1.00&max=80.00
    @GetMapping("sub4")
    public void method4(MyDto25 dto){
//        MyDto25 dto = new MyDto25();
//        dto.setMin(1.00);
//        dto.setMax(80.00);
        List<String> list = dao.select4(dto);
        System.out.println("list.size() = " + list.size());
    }

    // /main30/sub5?country1=germany&country2=france
    @GetMapping("sub5")
    private void method5(MyDto26 dto){
        // country1 또는 (or) country2에 사는 고객명들
       List<String> list =  dao.select5(dto);
       list.forEach(System.out::println);
    }

    // 좀더 복잡한 경우
    // /main30/sub6?from=1996-09-01&to=1996-09-30
    @GetMapping("sub6")
    public void method6(MyDto27 dto1, MyDto28 dto2){
        Integer num = dao.select6(dto1, dto2);
        System.out.println("num = " + num);

    }

    // /main30/sub7?page=2&rows=10&keyword=a
    @GetMapping("sub7")
    public void method7(MyDto29 dto1,MyDto30 dto2){
        
        //코드 작성...
//        dto1.setFrom((dto1.getPage() -1) * dto1.getRows());
//        dto2.setKeyword("%" + dto2.getKeyword() + "%");

        List<String> names = dao.select7(dto1, dto2);

        System.out.println("dto1.getPage() = " + dto1.getPage());
        names.forEach(System.out::println);
    }

    // /main30/sub8?name=son&country=korea
    @GetMapping("sub8")
    public void method8(MyDto31 dto){

        int row = dao.insert1(dto);
        System.out.println(row + "행이 입력되었습니다.");
    }

    @GetMapping("sub9")
    public void method9(){

    }

    // /main30/sub9
    @PostMapping("sub10")
    public void method10(MyDto32 emp){
        int row = dao.insert2(emp);
        System.out.println(row + "행이 입력됨");
    }

    // 삭제 하는 쿼리 10.19일
    // /main30/sub11?id=5
    @GetMapping("sub11")
    public void method11(Integer id){
        int rows = dao.delete1(id);
        System.out.println(rows + "개 행이 지워짐");
    }

    // /main30/sub12?pid=3
    // 3번 상품이 삭제되는 메소드 완성
    @GetMapping("sub12")
    public void method12(Integer pid){
        int rows = dao.delete2(pid);
        System.out.println(rows + "개 행이 지워짐");
    }

    // 업데이트
    // /main30/sub13?id=2
    @GetMapping("sub13")
    public void method13(Integer id, Model model){
        // 직원 조회
        MyDto33Employee employee =dao.select8(id);
        model.addAttribute("employee", employee);

    }
    @PostMapping("sub14")
    public String method14(MyDto33Employee employee, RedirectAttributes rttr) {
        // 직원 수정
        int rows = dao.update1(employee);

        // 모델에 추가
        if (rows == 1) {
            rttr.addFlashAttribute("message", "정보가 수정되었습니다.");
        } else {
            rttr.addFlashAttribute("message", "정보가 수정되지 않았습니다.");
        }

        // 쿼리스트링 추가
        rttr.addAttribute("id", employee.getId());
        return "redirect:/main30/sub13";
    }

    // Get /main30/sub15?id=3
    @GetMapping("sub15")
    public void method15(Integer id, Model model){
    //3번 고객 조회 -> view 로 포워딩
      MyDto34Customer customer = dao.select9(id);
      model.addAttribute("customer",customer);

    }
    // post / main30/sub16
    // 고객 정보 수정 -> main30/sub15?id=3 redirect
    @PostMapping("sub16")
    public String method16(MyDto34Customer customer,RedirectAttributes rttr){
        int rows = dao.update2(customer);
        // 모델에 추가
        if (rows == 1) {
            rttr.addFlashAttribute("message", "정보가 수정되었습니다.");
        } else {
            rttr.addFlashAttribute("message", "정보가 수정되지 않았습니다.");
        }
        // 쿼리스트링 추가
        rttr.addAttribute("id", customer.getId());
        return "redirect:/main30/sub15";
    }


}
