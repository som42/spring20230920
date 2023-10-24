package com.example.spring20230920.dao;

import com.example.spring20230920.domain.MyDto40;
import com.example.spring20230920.domain.MyDto41;
import org.apache.ibatis.annotations.*;

import java.time.LocalDate;
import java.util.Map;
import java.util.Objects;

@Mapper
public interface MyDao7 {
    @Select("""
            SELECT *
            FROM customers
            WHERE CustomerID = #{id}
            """)
    Map<String, Objects> selectByCustomerId(Integer id);

    @Select("""
            SELECT *
            FROM employees
            WHERE EmployeeID = #{id}
            """)
    Map<String, Objects> selectByEmployeeId(Integer id);

    @Insert("""
            INSERT INTO employees(LastName,FirstName,BirthDate)
            VALUES (#{lastName}, #{firstName}, #{birthDate})
            """)
    int inserEmployee(String lastName, String firstName, LocalDate birthDate);

    @Insert("""
            INSERT INTO products(ProductName, Price, CategoryID)
            VALUES (#{name}, #{price}, #{category})
            """)
    int inserProduct(String name, Double price, Integer category);

    @Delete("""
            DELETE FROM products
            WHERE ProductID = #{pid}
            """)
    int deleteByProductId(Integer pid);

    @Delete("""
            DELETE FROM customers
            WHERE CustomerID = #{pid}
            """)
    int deleteByCustomerId(Integer pid);

    //put 할때는 주로 업데이트
    @Update("""
            UPDATE products
            SET Price = #{price},
                CategoryID = #{category},
                ProductName = #{name} 
            WHERE
                ProductID = #{id}
            """)
    int updateProduct(MyDto40 dto);

    @Update("""
            UPDATE employees
            SET LastName = #{lastName},
                FirstName = #{firstName},
                BirthDate = #{birthDate}
            WHERE 
                EmployeeID = #{id}
            """)
    int updateEmployee(MyDto41 dto);



}
