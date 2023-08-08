package com.training.loggingtesting.training.services;
import com.training.loggingtesting.training.entities.MyMusic;
import com.training.loggingtesting.training.exceptions.MusicNotFoundException;

import java.util.List;

public interface IMusicService {

    public MyMusic addMusicData(MyMusic data);

    public MyMusic deleteMusicData(String name);

    public List<MyMusic> getAllMusicData();

    public MyMusic getMusicByName(String name) throws MusicNotFoundException;

    public MyMusic updateMusicData(String name , MyMusic movieData) throws MusicNotFoundException;

    public List<MyMusic> getMusicByGenre();


}
