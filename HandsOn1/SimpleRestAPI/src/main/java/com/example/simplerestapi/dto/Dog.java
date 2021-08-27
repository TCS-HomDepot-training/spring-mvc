package com.example.simplerestapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
public class Dog {

    private String name;
    private String breed;

}
