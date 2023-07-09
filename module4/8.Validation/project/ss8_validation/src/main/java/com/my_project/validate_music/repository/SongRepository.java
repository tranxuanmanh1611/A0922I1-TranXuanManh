package com.my_project.validate_music.repository;

import com.my_project.validate_music.entity.Song;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface SongRepository extends CrudRepository<Song,Integer> {
}
