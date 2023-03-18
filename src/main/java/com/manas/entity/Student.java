package com.manas.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "students")
public class Student {

    @Id
    @SequenceGenerator(name = "student_id_gen",
    sequenceName = "student_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "student_id_gen", strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    private int age;
    private String email;

    private LocalDate localDate;

    private Boolean isBlocked;

    public Student(String name, int age, String email, LocalDate localDate, Boolean isBlocked) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.localDate = localDate;
        this.isBlocked = isBlocked;
    }
}
