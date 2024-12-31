package com.example.test1.POJO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Elderly {
    private Integer ID;
    private String image;
    private String name;
    private Integer age;
    private String room;
    private String disease;
    private String marriageStatus;
    private String phoneNumber;
}
