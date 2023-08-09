package com.training.loggingtesting.ordersdemo.services;

import com.training.loggingtesting.ordersdemo.CountrySales;
import com.training.loggingtesting.ordersdemo.Order;
import com.training.loggingtesting.ordersdemo.repos.IOrderRepo;
import com.training.loggingtesting.training.entities.MyMusic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
        List<CountrySales> sales = new ArrayList<>();
        //AggregationResults<List<Order>> orders =  repo.getCountryWiseRevenue();

        List<Order> orders =  repo.getCountryWiseRevenue();
       // orders.forEach((eList)->{
           orders.forEach(e->{
             CountrySales sale =  new CountrySales();
            sale.setCountry(e.getCountry());
            sale.setTotal_sales(e.getPrice()*e.getQuantity());

            sales.add(sale);
        });

        return sales;

    }
}
