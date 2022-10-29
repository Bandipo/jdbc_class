package com.baog.dto;


import lombok.Data;

@Data
public class CustomerDto {

    private long id;
    private final String firstName;
    private final String lastName;
    private final String email;
}
