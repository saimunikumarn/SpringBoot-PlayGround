package com.learning.orderservice.controllers;

import com.learning.orderservice.dto.OrderDto;
import com.learning.orderservice.models.OrderDetails;
import com.learning.orderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;

    }

    @RequestMapping("/orderHealth")
    public String getOrderHealth() {
        return "I am fine, Thanks for checking!!! from order Service";
    }

    @RequestMapping("/productHealth")
    public String getProductHealth() {
        return orderService.getProductServiceHealth();
    }
    
    @GetMapping("/findOrder/{index}")
    public ResponseEntity<OrderDetails> findOrder(@PathVariable int index) {
        return new ResponseEntity<>(orderService.getOrder(index), HttpStatus.OK);
    }

    @GetMapping("/findOrderByUid/{uId}")
    public ResponseEntity<List<OrderDetails>> findOrderByUid(@PathVariable int uId) {
        return new ResponseEntity<>(orderService.getOrderByUid(uId), HttpStatus.OK);
    }

    @GetMapping("/orders")
    public List<OrderDetails> getAllOrders() {
        return orderService.getAllOrders();
    }

    @PostMapping("/saveOrder")
    public ResponseEntity<OrderDetails> saveOrder(@RequestBody OrderDetails orderDetails) {
        return new ResponseEntity<>(orderService.saveOrder(orderDetails), HttpStatus.CREATED);
    }

    @PutMapping("/updateOrder/{oId}")
    public ResponseEntity<OrderDetails> updateOrder(@PathVariable int oId, @RequestBody OrderDetails orderDetails) {
        return new ResponseEntity<>(orderService.updateOrder(oId, orderDetails), HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteOrder/{oId}")
    public ResponseEntity<String> deleteOrder(@PathVariable int oId) {
        orderService.deleteOrder(oId);
        return new ResponseEntity<>("Order Deleted with id " + oId, HttpStatus.OK);
    }

    @GetMapping("/products/{oId}")
    public OrderDto getProducts(@PathVariable Integer oId) {
        return orderService.getProductsWithOrderId(oId);
    }
}