package com.training.loggingtesting.ordersdemo.repos;

import com.training.loggingtesting.ordersdemo.Order;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface IOrderRepo extends MongoRepository<Order,String> {

    @Aggregation(pipeline = {
            "{'$group':{_id:'$country',total:{$sum:'$sales'}}}"
    })
  //  AggregationResults <List<Order>> getCountryWiseRevenue();

List<Order> getCountryWiseRevenue();


}
