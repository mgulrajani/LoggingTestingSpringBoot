package com.training.loggingtesting.ordersdemo;

import com.training.loggingtesting.ordersdemo.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderService service;

    @GetMapping("/countrysales")
    public ResponseEntity<List<CountrySales>> getCountrySales(){

        return ResponseEntity.ok(service.getCountrySales());

    }

    @GetMapping
    public ResponseEntity<List<Order>>  getAll(){
        return ResponseEntity.ok(service.getAllOrders());

    }

}
