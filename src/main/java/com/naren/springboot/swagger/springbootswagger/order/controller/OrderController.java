package com.naren.springboot.swagger.springbootswagger.order.controller;

import com.naren.springboot.swagger.springbootswagger.order.model.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api")
public class OrderController {
    List<Order> orderList = new ArrayList<>();

    {
        orderList.add(new Order(1000L, 100L, "Order1", 900, false, null));
        orderList.add(new Order(1001L, 101L, "Order2", 901, false, null));
        orderList.add(new Order(1002L, 102L, "Order3", 902, true, null));
        orderList.add(new Order(1003L, 103L, "Order4", 903, true, null));
        orderList.add(new Order(1004L, 104L, "Order5", 904, false, null));
        orderList.add(new Order(1005L, 105L, "Order6", 905, true, null));
        orderList.add(new Order(1006L, 106L, "Order7", 906, true, null));
        orderList.add(new Order(1007L, 107L, "Order8", 907, true, null));
        orderList.add(new Order(1008L, 108L, "Order9", 908, false, null));
        orderList.add(new Order(1009L, 109L, "Order10", 909, true, null));
    }

    @GetMapping("/orders")
    public ResponseEntity<Collection<Order>> findAllOrders() {
        return new ResponseEntity<>(orderList, HttpStatus.OK);
    }

    @GetMapping("/orders/{id}")
    public ResponseEntity<Order> findOrderById(@PathVariable Long id) {

        Order currentOrder = orderList.stream().filter(order->order.getId().equals(id)).findFirst().orElse(null);

        if (currentOrder != null) {
            return new ResponseEntity<>(currentOrder, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("order/{id}/orderaction/acceptShipDate")
    public ResponseEntity<Order> addShipDatetoOrder(@PathVariable Long id) {

        Order currentOrder = orderList.stream().filter(order->order.getId().equals(id)).findFirst().orElse(null);

        if (currentOrder != null) {
            currentOrder.setShipDate(new Date());
            return new ResponseEntity<>(currentOrder, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}