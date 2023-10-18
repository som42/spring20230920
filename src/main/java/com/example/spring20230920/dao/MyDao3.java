package com.example.spring20230920.dao;

import com.example.spring20230920.domain.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Mapper
public interface MyDao3 {
    // 1행 1열
    @Select("""
            SELECT customerName FROM customers
            WHERE CustomerID = 1
            """)
    String select1();

    @Select("""
            SELECT price FROM products
            WHERE ProductID = 1
            """)
    Double select2();

    @Select("""
            SELECT LastName FROM employees
            WHERE EmployeeID = 1
            """)
    String select3();

    @Select("""
            SELECT BirthDate FROM employees
            WHERE EmployeeID = 2
            """)
    LocalDate select4();

    // 행 여러 개 열이 1개
    @Select("""
            SELECT DISTINCT Country
            FROM customers
            ORDER BY 1
            """)
    List<String> select5(); // 여러행이라서 list

    @Select("""
            SELECT BirthDate 
            FROM employees
            ORDER BY 1
            """)
    List<String> select6();

    @Select("""
            SELECT Price
            FROM products
            ORDER BY 1
            """)
    List<Double> select7();

    // 행은 1개 여러 개 열
    @Select("""
            SELECT CustomerID,CustomerName,Address
            FROM customers
            WHERE CustomerID = 1
            """)
    Map<String, Object> select8();

    @Select("""
            SELECT ProductName, Price, CategoryName
            FROM products p 
            JOIN categories c 
            ON c.CategoryID = p.CategoryID
            WHERE p.ProductID = 1  
            """)
    Map<String,Object> select9();

    // 자바 빈으로 해보기
    // 3개의 열 1 행
    // 프로퍼티 명은 조회된 명으로 해주면된다.( 대소문자 구분안함)
    @Select("""
            SELECT EmployeeID, LastName, FirstName
            FROM employees
            WHERE EmployeeID = 1
            """)
    MyDto19 select10();

    @Select("""
            SELECT ProductName name, Price, c.CategoryID
            FROM products p 
            JOIN categories c 
            ON p.CategoryID = c.CategoryID
            WHERE ProductID = 1
            """)
    MyDto20 select11();

    @Select("""
            SELECT CustomerID id, 
                   CustomerName name, 
                   Country
            FROM customers
            WHERE CustomerID = 2
            """)
    MyDto21 select12();

    // 여러열 여러행
    @Select("""
            SELECT ProductID id, 
                   ProductName name, 
                   Price
            FROM products
            WHERE CategoryID = 2
            ORDER BY Price 
            """)
    // 가격 순으로 조회 하겠다
    List<Map<String, Object>> select13();

    @Select("""
            SELECT p.ProductName name,
                   od.Quantity,
                   p.Price
            FROM products p
            JOIN orderdetails od
            ON p.ProductID = od.ProductID
            JOIN orders o 
            ON o.OrderID = od.OrderID
            WHERE OrderDate = '1996-07-04'
            ORDER BY name
            """)
    List<Map<String, Object>> select14();

    // 여러행 여러열 자바빈으로 해보기
    @Select("""
            SELECT p.ProductName name,
                   od.Quantity,
                   p.Price
            FROM products p
            JOIN orderdetails od
            ON p.ProductID = od.ProductID
            JOIN orders o 
            ON o.OrderID = od.OrderID
            WHERE OrderDate = '1996-07-04'
            ORDER BY name
            """)
    List<MyDto22> select15();

    //sub16 요청시
    // 1번 카테고리 상품들이 주문된 날짜, 상품명, 카테고리명, 수량, 가격
    // 날짜, 상품명 순으로 정렬
    @Select("""
            SELECT o.OrderDate, 
                   p.ProductName name,
                   c.CategoryName,
                   od.Quantity,
                   p.Price 
            FROM products p 
                    JOIN orderdetails od
                        ON p.ProductID = od.ProductID
                    JOIN orders o 
                        ON o.OrderID = od.OrderID
                    JOIN categories c 
                        ON c.CategoryID = p.CategoryID
            WHERE c.CategoryID = 1
            ORDER BY OrderDate,ProductName
            """)
    List<MyDto23> select16();

    // 자주 곁는일
    @Select("""
            SELECT CustomerName
            FROM customers
            WHERE CustomerID = 100
            """)
    // 100 번째 고객이 없다면? null로 넘어간다.
    String select17();

    @Select("""
            SELECT CustomerID
            FROM customers
            WHERE CustomerID = 100
            """)
    // 100 번째 고객이 없는걸 int로 줄수 없다!
    // 인셉션을 보기 싫으면 참조 타입으로 주는게 좋다
    Integer select18();

    // 프로 퍼티를 일치하지 않게 쓰면 내용이 들어 가지 않고 null로 남아있다.
    // 빈에 프로퍼티 명과, 쿼리에 조회된 컬럼명이 다르면 내용이 들어가지 않는다
    @Select("""
            SELECT CustomerID id,
                   CustomerName name,
                   Country
            FROM customers
            WHERE CustomerID = 1
            """)
    MyDto24 select19();

    // 하나의 결과가 아닌 여러개의 결과를 출력할려고 했다.
    // 쿼리를 여러타입으로 조회하게 해놓고 list로 안했구나
    // 오류 메세지 보고 판단을 잘해야 한다.!
    @Select("""
            SELECT CustomerID id,
                   CustomerName name,
                   Country
            FROM customers
            WHERE CustomerID > 1
            """)
    MyDto24 select20();
}
