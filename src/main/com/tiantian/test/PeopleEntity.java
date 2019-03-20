package com.tiantian.test;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PeopleEntity {
    private Integer age;
    private String name;
    private String callNumber;
    private String address;
    private String emile;

    //constructor, getters, setters etc.

    public PeopleEntity() {
    }
}
