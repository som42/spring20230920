package com.example.spring20230920.dao;

import com.example.spring20230920.domain.*;
import org.apache.ibatis.annotations.*;

import java.time.LocalDate;
import java.util.List;

@Mapper // 애로 클래스 만들어서 스프링 빈으로 만들어야 겠구나
public interface MyDao4 {
    @Select("""
            SELECT CustomerName
            FROM customers
            WHERE CustomerID = #{i}
            """)
    // 물음표 되신 #{ 파라미터 명 넣어준다}
    // 파라미터가 하나면 이름이 일치하지 않아도 됨
    // 두개 이상이면 꼭 이름을 맞춰서 줘야함!
    String select1(int i);

    @Select("""
            SELECT ProductName
            FROM products
            WHERE Price BETWEEN #{from} AND #{to}
            """)
    // 파라미터 두개일때는 꼭 이름 맞춰서 해야한다
    List<String> select2(Double from, Double to);

    @Select("""
            SELECT DISTINCT p.ProductName
            FROM products p
                JOIN orderdetails od
                    ON p.ProductID = od.ProductID
                JOIN orders o
                    ON o.OrderID = od.OrderID
            WHERE OrderDate BETWEEN #{from} AND #{to} 
            ORDER BY 1
            """)
    List<String> select3(LocalDate from, LocalDate to);

    @Select("""
            SELECT ProductName
            FROM products
            WHERE Price BETWEEN #{min} AND #{max}
            """)
     List<String> select4(MyDto25 dto);

    @Select("""
            SELECT CustomerName
            FROM customers 
            WHERE Country = #{country1} OR #{country2}
            """)
    // WHERE Country IN (#{country1}, #{country2})
    List<String> select5(MyDto26 dto);

    // 두개의 MyDto27, MyDto28 가지고 있을때는 요롷게
    @Select("""
            SELECT COUNT(OrderID)
            FROM orders
            WHERE OrderDate BETWEEN #{dto1.from} AND #{dto2.to} 
            """)
    Integer select6(MyDto27 dto1, MyDto28 dto2);

    @Select("""
            SELECT CustomerName
            FROM customers
            WHERE CustomerName LIKE #{dto2.keyword}
            LIMIT #{dto1.from}, #{dto1.rows}
            """)
    List<String> select7(MyDto29 dto1, MyDto30 dto2);

    // Insert
    @Insert("""
            INSERT INTO  customers(CustomerName, Country)
            VALUE (#{name},#{country})
            """)
    int insert1(MyDto31 dto);

    @Insert("""
            INSERT INTO employees(FirstName, LastName)
            VALUE (#{firstName},#{lastName})
            """)
    int insert2(MyDto32 emp);

    // 삭제 하는 쿼리
    @Delete("""
            DELETE  FROM  customers
            WHERE CustomerID = #{id}
            """)
    // 파라미터랑 똑같이 #{ 안에 넣어주면 된다 }
    int delete1(Integer id);

    @Delete("""
            DELETE FROM products
            WHERE ProductID = #{pid}
            """)
    int delete2(Integer pid);

    // 업데이트
    // 별칭을 줬을때는 * 로 하면 값이 제대로 안나온다.
    @Select("""
            SELECT EmployeeID id,
                   LastName,
                   FirstName,
                   BirthDate,
                   Photo, 
                   Notes
            FROM employees
            WHERE EmployeeID = #{id}
            """)
    MyDto33Employee select8(Integer id);

    @Update("""
            UPDATE employees
            SET LastName = #{lastName},
                FirstName = #{firstName},
                Photo = #{photo},
                Notes = #{notes},
                BirthDate = #{birthDate}
            WHERE EmployeeID = #{id}  
            """)
    int update1(MyDto33Employee employee);


    //고객 조회
    @Select("""
            SELECT CustomerID id,
                   CustomerName,
                   ContactName,
                   Country,
                   City,
                   PostalCode,
                   Address
            FROM customers
            WHERE CustomerID = #{id}
            """)
    MyDto34Customer select9(Integer id);

    // 고객 수정
    @Update("""
            UPDATE customers
            SET CustomerName = #{customerName},
                ContactName = #{contactName},
                Country = #{country},
                City = #{city},
                PostalCode = #{postalCode},
                Address = #{address}
            WHERE CustomerID = #{id}
            """)
    int update2(MyDto34Customer customer);



}
