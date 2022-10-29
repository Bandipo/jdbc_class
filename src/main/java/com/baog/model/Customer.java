package com.baog.model;


import lombok.*;


@Data
public class Customer {

    private final long id;
    private final String firstName;
    private final String lastName;
    private final String email;
}
