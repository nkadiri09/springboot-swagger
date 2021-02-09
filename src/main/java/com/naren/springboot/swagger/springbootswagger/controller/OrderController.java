package com.naren.springboot.swagger.springbootswagger.controller;

import com.naren.springboot.swagger.springbootswagger.model.Item;
import com.naren.springboot.swagger.springbootswagger.model.Order;
import io.swagger.annotations.Api;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/orders")
@Api(value = "/orders", description = "Operations about Orders")
public class OrderController {
    List<Order> orderList = new ArrayList<>();

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
    }

    @GetMapping("/")
    public ResponseEntity<Collection<Order>> findAllOrders() {
        return new ResponseEntity<>(orderList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> findOrderById(@PathVariable Long id) {

        Order currentOrder = orderList.stream().filter(order->order.getId().equals(id)).findFirst().orElse(null);

        if (currentOrder != null) {
            return new ResponseEntity<>(currentOrder, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/{id}/orderaction/acceptShipDate")
    public ResponseEntity<Order> addShipDateToOrder(@PathVariable Long id) {

        Order currentOrder = orderList.stream().filter(order->order.getId().equals(id)).findFirst().orElse(null);

        if (currentOrder != null) {
            currentOrder.setShipDate(new Date());
            return new ResponseEntity<>(currentOrder, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/{id}/orderaction/cancelItems")
    public ResponseEntity<Order> cancelItems(@PathVariable Long id) {

        Order currentOrder = orderList.stream().filter(order->order.getId().equals(id)).findFirst().orElse(null);

        if (currentOrder != null) {
            currentOrder.setShipDate(new Date());
            return new ResponseEntity<>(currentOrder, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/{id}/orderaction/cancelOrder")
    public ResponseEntity<Order> cancelOrder(@PathVariable Long id) {

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