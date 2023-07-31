package ghost_company.music_app.service;

import ghost_company.music_app.entity.Music;
import ghost_company.music_app.repository.MusicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusicService {
    @Autowired
    MusicRepository musicRepository;
    public List<Music> getAllMusic(){
        return musicRepository.getAllMusic();
    }
    public void save(Music music){
        musicRepository.saveMusic(music);
    }
    public void delete(int id){
        musicRepository.deleteMusic(id);
    }

    public Music findById(int id){
       return musicRepository.findById(id);
    }
}