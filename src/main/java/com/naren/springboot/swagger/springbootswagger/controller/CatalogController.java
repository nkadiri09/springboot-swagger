package com.naren.springboot.swagger.springbootswagger.controller;


import com.naren.springboot.swagger.springbootswagger.model.Catalog;
import com.naren.springboot.swagger.springbootswagger.model.Item;
import com.naren.springboot.swagger.springbootswagger.model.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/catalog")
public class CatalogController {

    List<Order> orderList = new ArrayList<>();
    Catalog catalogList = new Catalog();

    {
        Item sampleItem = new Item();
        sampleItem.setItems("itemone");
        List<Item> itemList = Arrays.asList(sampleItem);
        orderList.add(new Order(1000L, 100L, "Order1", 900, false, null, itemList));
        orderList.add(new Order(1001L, 101L, "Order2", 901, false, null, itemList));
        orderList.add(new Order(1002L, 102L, "Order3", 902, true, null, itemList));
        orderList.add(new Order(1003L, 103L, "Order4", 903, true, null, itemList));
        orderList.add(new Order(1004L, 104L, "Order5", 904, false, null, itemList));
        orderList.add(new Order(1005L, 105L, "Order6", 905, true, null, itemList));
        orderList.add(new Order(1006L, 106L, "Order7", 906, true, null, itemList));
        orderList.add(new Order(1007L, 107L, "Order8", 907, true, null, itemList));
        orderList.add(new Order(1008L, 108L, "Order9", 908, false, null, itemList));
        orderList.add(new Order(1009L, 109L, "Order10", 909, true, null, itemList));

        catalogList.setOrders(orderList);

    }

    @GetMapping("/")
    public ResponseEntity<Catalog> findAllOrders() {
        return new ResponseEntity<>(catalogList, HttpStatus.OK);
    }
}
