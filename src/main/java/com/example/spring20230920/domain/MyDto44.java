package com.example.spring20230920.domain;

import lombok.Data;
import software.amazon.awssdk.services.s3.endpoints.internal.Value;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Stack;

@Data
public class MyDto44 {
    private String name;
    private List<String> email;
    private Map<String, Object> home;
    private Double price;
    private Double weight;
    private Boolean married;
}
