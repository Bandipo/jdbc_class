package com.baog.model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Builder
@ToString
public class CustomerCart {

    private  long id;
    private int customerId;
    private int productId;
    private int quantity;
}
