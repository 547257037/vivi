package com.tiantian.test;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PeopleDTO {
    private String phoneNumber;
    private String address;
    private String emile;
    private User  user;

    //constructor, getters, setters etc.
}
