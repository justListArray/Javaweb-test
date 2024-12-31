package com.example.project01.POJO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    private Integer ID;
    private String image;
    private String name;
    private String dormitoryNumber;
    private String roomNumber;
    private String gender;
}
