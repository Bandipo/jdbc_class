package com.baog.model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Builder
@ToString
public class Product {

    private  long id;
    private String productName;
    private int categoryId;
    private String description;
    private int quantity;
}


