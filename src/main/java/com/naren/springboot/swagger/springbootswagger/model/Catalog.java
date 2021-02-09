package com.naren.springboot.swagger.springbootswagger.model;

import lombok.Data;

import java.util.List;

@Data
public class Catalog {
    private List<Order> orders;
}
