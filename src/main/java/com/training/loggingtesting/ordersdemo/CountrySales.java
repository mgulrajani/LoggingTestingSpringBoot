package com.training.loggingtesting.ordersdemo;

import org.springframework.stereotype.Component;

@Component
public class CountrySales {
    private String country;
    private double total_sales;

    public CountrySales() {
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public double getTotal_sales() {
        return total_sales;
    }

    public void setTotal_sales(double total_sales) {
        this.total_sales = total_sales;
    }
}
