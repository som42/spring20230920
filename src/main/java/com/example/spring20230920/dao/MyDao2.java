package com.example.spring20230920.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper // 이 인터페이스로 클래스만들고, 다함
public interface MyDao2 {
    @Select("""
    SELECT LastName FROM employees
    WHERE EmployeeID = #{id}  
""")
    String select(Integer id);
}
