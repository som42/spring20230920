package com.example.spring20230920.controller;

import com.example.spring20230920.domain.MyDto00;
import com.example.spring20230920.domain.MyDto15;
import com.example.spring20230920.domain.MyDto16;
import org.eclipse.tags.shaded.org.apache.regexp.RE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("main20")
public class Controller20 {

    @Autowired
    private DataSource dataSource;

    @GetMapping("sub1")
    public void method1() {

    }

    @GetMapping("sub2")
    public String method2(String id, Model model) throws SQLException {
        // 쿼리 작성 (method6 참고)
        String sql = """
                SELECT CustomerID, CustomerName, Address, Country
                FROM customers
                WHERE CustomerID = ?
                """;

        System.out.println("sql = " + sql);

        // 쿼리 실행
        Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, id);
        ResultSet resultSet = statement.executeQuery();

        List<MyDto15> list = new ArrayList<>();

        try (connection; statement; resultSet) {

            // 실행 결과 처리 (method6 참고, MyDto15 사용)
            while (resultSet.next()) {
                MyDto15 dto = new MyDto15();
                dto.setId(resultSet.getInt(1));
                dto.setName(resultSet.getString(2));
                dto.setAddress(resultSet.getString(3));
                dto.setCountry(resultSet.getString(4));

                list.add(dto);
            }
        }
        // 처리한 결과 model에 attribute로 넣고
        model.addAttribute("customerList", list);

        return "/main19/sub6";
    }

    @GetMapping("sub3")
    public void method3(String id) throws SQLException {
        String sql = """
                SELECT customerId, customerName, country
                FROM customers
                WHERE customerId = ?
                """;

        Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setString(1, id);
//        statement.setInt(1, 3);

        ResultSet resultSet = statement.executeQuery();

        try (connection; statement; resultSet) {
            while (resultSet.next()) {
                System.out.println();
                System.out.println("고객 정보");
                System.out.println("id = " + resultSet.getString(1));
                System.out.println("name = " + resultSet.getString(2));
            }
        }
    }
    
    @GetMapping("sub4")
    public void method4(String pid) throws SQLException {
        String sql = """
                SELECT productId, productName
                FROM products
                WHERE productId = ?
                """;
        Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1,pid);
        ResultSet resultSet = statement.executeQuery();

        try (connection; statement; resultSet) {

            while (resultSet.next()) {
                System.out.println();
                System.out.println("상품 정보");
                System.out.println("상품 번호 = " + resultSet.getInt(1));
                System.out.println("상품명 = " + resultSet.getString(2));
            }
        }
    }

    @GetMapping("sub5")
    public void method5(String pid) throws SQLException {
        String sql = """
                SELECT Country,CustomerName
                FROM customers
                WHERE Country = ?;
                """;

        Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1,pid);
        ResultSet resultSet = statement.executeQuery();

        try(connection; statement;resultSet){
            while (resultSet.next()){
                System.out.println("스페인에 사는 고객들 명단");
                System.out.println("나라" + resultSet.getString(1));
                System.out.println("이름 " + resultSet.getString(2));
            }
        }

    }

    @GetMapping("sub6")
    public void method6(String c1, String c2) throws SQLException {
        String sql = """
                SELECT customerName, country
                FROM customers
                WHERE country = ? OR country = ?
                """;

        Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setString(1, c1);
        statement.setString(2, c2);

        ResultSet resultSet = statement.executeQuery();

        try (connection; statement; resultSet) {

            System.out.println();
            System.out.println("고객 목록");
            while (resultSet.next()) {
                String country = resultSet.getString(2);
                String name = resultSet.getString(1);
                System.out.println(country + ":" + name);
            }
        }
    }

    @GetMapping("sub7")
    public void method7() {
    }

    @GetMapping("sub8")
    public String method8(Double min, Double max, Model model) throws SQLException {
        String sql = """
                SELECT productId, productName, unit, price
                FROM products
                WHERE price <= ? AND price >= ?
                """;

        Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setDouble(1, max);
        statement.setDouble(2, min);

        ResultSet resultSet = statement.executeQuery();

        List<MyDto16> list = new ArrayList<>();
        try (connection; statement; resultSet) {
            while (resultSet.next()) {
                MyDto16 dto = new MyDto16();
                dto.setId(resultSet.getInt(1));
                dto.setName(resultSet.getString(2));
                dto.setUnit(resultSet.getString(3));
                dto.setPrice(resultSet.getDouble(4));

                list.add(dto);
            }
        }

        model.addAttribute("productList", list);

        return "/main19/sub5";
    }

    // /main20/sub9?country=spain&country=mexico&country=uk
    @GetMapping("sub9")
    public void method9(@RequestParam("country") List<String> countryList) throws SQLException {
        String questionMarks = "";
        for (int i = 0; i < countryList.size(); i++) {
            questionMarks += "?";

            if (i < countryList.size()-1) {
                questionMarks += ", ";
            }
        }
        // 특정 국가에 속한 고객들 조회
        String sql = """
    
                """;

//        System.out.println("sql = " + sql);

        Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);

        for (int i = 0; i < countryList.size(); i++) {
            statement.setString(i + 1, countryList.get(i));
        }
        ResultSet resultSet = statement.executeQuery();

        try (connection; statement; resultSet) {
            System.out.println("고객 목록");
            while (resultSet.next()) {
                String name = resultSet.getString(2);
                String country = resultSet.getString(7);

                System.out.println(name + " : " + country);
            }
        }
    }
    @GetMapping("sub10")
    public void method10(Model model) throws SQLException {
        // 공급자의 국가 목록 조회
        String sql = """
                SELECT DISTINCT country 
                FROM suppliers
                """;

        Connection connection = dataSource.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        List<String> list = new ArrayList<>();
        try (connection; statement; resultSet) {
            while (resultSet.next()) {
                list.add(resultSet.getString(1));
            }
        }

        model.addAttribute("countryList", list);
    }

    @GetMapping("sub11")
    public void method11(Model model ,@RequestParam ("country") List<String> countrylist) throws SQLException {
    // 국가로 공급자 조회

        String a = "";
        for (int i = 0; i < countrylist.size(); i++) {
            a+= "?";
            if (i<countrylist.size()-1){
                a+=",";
            }
        }
        String sql = """
                SELECT DISTINCT Country, SupplierName
                FROM  suppliers
                WHERE Country IN (
                """
                + a + ")";


        Connection connection = dataSource.getConnection();
        // 물음표 상태면 preparedStatement를 쓴다.
        PreparedStatement statement = connection.prepareStatement(sql);
        // setString 갯수만큼 돌리려고
        for (int i = 0; i < countrylist.size(); i++) {
            statement.setString(i+1, countrylist.get(i));
        }
        ResultSet resultSet = statement.executeQuery();

        List<MyDto00> list = new ArrayList<>();
        try (connection; statement; resultSet) {
            while (resultSet.next()) {
                MyDto00 dto = new MyDto00();
                dto.setCountry(resultSet.getString(1));
                dto.setName(resultSet.getString(2));

                list.add(dto);
            }
        }

    model.addAttribute("country",list);
    }
}