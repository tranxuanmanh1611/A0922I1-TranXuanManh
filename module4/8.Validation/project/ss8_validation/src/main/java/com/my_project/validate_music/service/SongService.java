package com.my_project.validate_music.service;

import com.my_project.validate_music.entity.Song;

import java.util.Optional;

public interface SongService {
    Iterable<Song> findAll();
    Song findById(int id);
    void save(Song song);
    void deleteById(int id);
}
