package com.example.spring20230920.dao;

import com.example.spring20230920.domain.MyDto33Employee;
import com.example.spring20230920.domain.MyDto34Customer;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MyDao10 {

    @Select("""
        SELECT CustomerName FROM customers
        WHERE CustomerID = 50
        """)
    String getCustomerName();

    @Select("""
        SELECT 
         customerId id,
         customerName name,
         contactName,
         address,
         city,
         postalCode, 
         country
         FROM customers
        WHERE customerId = 50
        """)
    MyDto34Customer getCustomer();

    @Select("""
        SELECT 
         customerId id,
         customerName,
         contactName,
         address,
         city,
         postalCode, 
         country
         FROM customers
        WHERE customerId = #{id}
        """)
    MyDto34Customer getCustomerById(Integer id);


    @Select("""
        SELECT 
        EmployeeID id,
        LastName,
        FirstName,
        Photo,
        Notes,
        BirthDate
        FROM employees
        WHERE EmployeeID = #{id}
            """)
    MyDto33Employee getEmployeesById(Integer id);

    @Select("""
            SELECT CustomerID
            FROM customers
            ORDER BY CustomerID
            """)
    List<Integer> getCustomerIdList();

    @Select("""
            SELECT EmployeeID
            FROM employees
            ORDER BY EmployeeID
            """)
    List<Integer> getEmployeesIdList();
}
