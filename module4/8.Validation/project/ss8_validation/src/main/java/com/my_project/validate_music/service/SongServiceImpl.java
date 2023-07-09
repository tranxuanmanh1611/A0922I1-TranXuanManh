package com.my_project.validate_music.service;

import com.my_project.validate_music.entity.Song;
import com.my_project.validate_music.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Size;
import java.util.Optional;

@Service
public class SongServiceImpl implements SongService{
    @Autowired
    SongRepository songRepository;
    @Override
    public Iterable<Song> findAll() {
        return songRepository.findAll();
    }

    @Override
    public Song findById(int id) {
        return songRepository.findById(id).get();
    }

    @Override
    public void save(Song song) {
        songRepository.save(song);
    }

    @Override
    public void deleteById(int id) {
        songRepository.deleteById(id);
    }
}
