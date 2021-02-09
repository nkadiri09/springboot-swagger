package com.naren.springboot.swagger.springbootswagger.order.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private Long id;
    private Long customerId;
    private String description;
    private long costInCents;
    private boolean isComplete;
    private Date shipDate;
}