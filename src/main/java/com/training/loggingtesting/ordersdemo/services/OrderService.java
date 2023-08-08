package com.training.loggingtesting.ordersdemo.services;

import com.training.loggingtesting.ordersdemo.CountrySales;
import com.training.loggingtesting.ordersdemo.Order;
import com.training.loggingtesting.ordersdemo.repos.IOrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private IOrderRepo repo;
    public List<Order> getAllOrders(){
        return  repo.findAll(); }

    public Order getOrderById(String id){
        return repo.findById(id).get();
    }

    public List<CountrySales> getCountrySales(){
        return repo.getCountrySales();
    }
}
