package com.manas.dto.response;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class StudentResponse {
    private Long id;
    private String name;
    private int age;
    private String email;
    private Boolean isBlocked;
}
