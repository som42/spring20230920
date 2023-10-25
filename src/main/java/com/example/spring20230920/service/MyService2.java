package com.example.spring20230920.service;

import com.example.spring20230920.dao.MyDao8;
import com.example.spring20230920.dao.MyDao9;
import com.example.spring20230920.domain.MyDto33Employee;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyService2 {

    private final MyDao9 dao;

    public boolean validate(MyDto33Employee dto) {
        if (dto.getBirthDate() == null){
            return false;
        }
        if (dto.getFirstName() ==  null || dto.getFirstName().isBlank()){
            return false;
        }
        if (dto.getLastName() == null || dto.getLastName().isBlank()){
            return false;
        }
        if (dto.getNotes() == null || dto.getNotes().isBlank()){
            return false;
        }
        return true;
    }

    public int add(MyDto33Employee dto) {
    // 실행 시키기전에 5초정도 딜레이를 준다
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return dao.insertEmployee(dto);
    }
}
