package com.training.loggingtesting.training.utils;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class ConnectionManager {

    private static MongoClient mongoClient;
    private static MongoDatabase database;

    public static MongoDatabase getDatabase(){

        mongoClient = MongoClients.create("mongodb://localhost:27017");
        database = mongoClient.getDatabase("music");
        return database;

    }
}
