package ghost_company.music_app.repository;

import ghost_company.music_app.entity.Music;

import java.util.List;

public interface MusicRepository {
    void saveMusic(Music music);
    List<Music> getAllMusic();
    void deleteMusic(int id);
    Music findById(int id);
}
