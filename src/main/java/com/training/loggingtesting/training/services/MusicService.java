package com.training.loggingtesting.training.services;

import com.training.loggingtesting.training.entities.MyMusic;
import com.training.loggingtesting.training.exceptions.MusicNotFoundException;
import com.training.loggingtesting.training.repo.IMyMusicRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MusicService implements IMusicService {

    @Autowired
    private IMyMusicRepo repo;

    @Override
    public MyMusic addMusicData(MyMusic data) {
        return repo.save(data);
    }



    @Override
    public MyMusic deleteMusicData(String name) {

        MyMusic m1 =repo.findByName(name);
        repo.delete(m1);
        return m1;

    }

    @Override
    public List<MyMusic> getAllMusicData() {
        return
                repo.findAll();
    }

    @Override
    public MyMusic getMusicByName(String name) throws MusicNotFoundException {
        return repo.findByName(name);
    }

    @Override
    public MyMusic updateMusicData(String name , MyMusic musicData) throws MusicNotFoundException {
        MyMusic music =  repo.findByName(name);
        music.setArtists(musicData.getArtists());
        music.setName(musicData.getName());
        music.setGenre(musicData.getGenre());

        repo.save(music);
        return music;
    }

    @Override
    public List<MyMusic> getMusicByGenre() {
        return repo.findByGenreTotal();
    }

    @Override
    public List<MyMusic> findAllPages(int pageno, int size) {
       Pageable pageable = PageRequest.of(pageno,size);
       Page<MyMusic> page = repo.findAll(pageable);
       return page.getContent();
    }


}