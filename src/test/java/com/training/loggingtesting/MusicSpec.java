package com.training.loggingtesting;

import com.training.loggingtesting.training.entities.MyMusic;
import com.training.loggingtesting.training.exceptions.MusicNotFoundException;
import com.training.loggingtesting.training.repo.IMyMusicRepo;
import com.training.loggingtesting.training.services.IMusicService;
import com.training.loggingtesting.training.services.MusicService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@SpringBootTest
public class MusicSpec {

    @Mock
    IMyMusicRepo repo;

    @InjectMocks
    MusicService service;

    List<MyMusic>   collection ;
    MyMusic music1 ,music2,music3;

    @BeforeEach
    public void firstBeforeEach() {
        MockitoAnnotations.initMocks(this);
    }

    @BeforeEach
    public void befEach(){
         music1 = new MyMusic("music1");
        music2=new MyMusic("music2");
        music3=new MyMusic("music3");

        collection = Arrays.asList(music1,music2,music3);


    }

    @Test
    public void getAllMusic(){

        when(repo.findAll()).thenReturn(collection);

       assertEquals(3,service.getAllMusicData().size());

        assertEquals(collection , service.getAllMusicData());
    }


    @Test
    public void getMusicSpec() throws MusicNotFoundException {

        when(repo.findByName("music1")).thenReturn(music1);
        MyMusic retval = service.getMusicByName("music1");
        assertEquals(music1,retval);
    }


    @Test
    public void addMusicSpec(){
        when(repo.save(music1)).thenReturn(music1);

        MyMusic newlyadded =  service.addMusicData(music1);
        assertEquals(newlyadded,music1 );
        assertEquals(4,collection.size()+1);
    }

    @Test
    public void  deleteMusicSpec(){

        when(repo.findByName(music1.getName())).thenReturn(music1).thenReturn(null);
        MyMusic musTobDel = service.deleteMusicData(music1.getName());
        assertEquals(musTobDel,music1);

    }


    @Test
    public void updateMusicSpec() throws MusicNotFoundException {
        when(repo.findByName(music2.getName())).thenReturn(music2);
        when(repo.save(music2)).thenReturn(music3);
        MyMusic updatedMusic =  service.updateMusicData(music2.getName(),music3);
        assertEquals(music3.getName(),updatedMusic.getName());

    }
}
