package com.manas.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class StudentRequest {
    private String name;
    private int age;
    private String email;
}
