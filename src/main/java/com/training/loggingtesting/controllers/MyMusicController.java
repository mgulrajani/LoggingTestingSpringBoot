package com.training.loggingtesting.controllers;

import com.training.loggingtesting.training.entities.MyMusic;
import com.training.loggingtesting.training.exceptions.MusicNotFoundException;
import com.training.loggingtesting.training.services.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/music")
public class MyMusicController {
    @Autowired
    private MusicService service;
    @GetMapping
    public ResponseEntity<List<MyMusic>> getMusic() {

            return ResponseEntity.ok(service.getAllMusicData());

        }

    @GetMapping("/name")
    public ResponseEntity<MyMusic> getMusicByName(@RequestParam String name1) throws MusicNotFoundException {

        return ResponseEntity.ok(service.getMusicByName(name1));


    }

    @PostMapping
    public ResponseEntity<MyMusic> addMusic(@RequestBody MyMusic music){
        return   ResponseEntity.ok(service.addMusicData(music));


    }


    @GetMapping("/genre")
    public ResponseEntity<List<MyMusic>> getByGenre(){

        return  ResponseEntity.ok(service.getMusicByGenre());

    }

   @GetMapping("/pages")
    public ResponseEntity<List<MyMusic>> getPageableMusic(@RequestParam(required = false, defaultValue = "0") int pageno, @RequestParam(required = false, defaultValue = "5") int size)
   {
       return ResponseEntity.ok(service.findAllPages(pageno,size));
}
}

