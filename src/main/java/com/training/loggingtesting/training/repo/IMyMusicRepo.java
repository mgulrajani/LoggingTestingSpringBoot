package com.training.loggingtesting.training.repo;

import com.training.loggingtesting.training.entities.MyMusic;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface IMyMusicRepo extends MongoRepository<MyMusic, String> {

    @Query("{'name':'?0'}")
    MyMusic findByName(String name);

    @Query(value="{genre:'?0'}",fields="{'name':1,'artists':1}")
    List<MyMusic> findAll(String genre);

}