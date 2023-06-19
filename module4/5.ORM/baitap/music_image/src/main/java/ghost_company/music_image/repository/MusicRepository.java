package ghost_company.music_image.repository;

import ghost_company.music_image.entity.Music;

import java.util.List;

public interface MusicRepository {
    void saveMusic(Music music);
    List<Music> getAllMusic();
    void deleteMusic(int id);
    Music findById(int id);
}
