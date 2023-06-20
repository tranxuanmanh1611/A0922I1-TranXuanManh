package ghost_company.music_app.repository;

import ghost_company.music_app.entity.Music;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class MusicImpl implements MusicRepository{
    @PersistenceContext
    EntityManager entityManager;
    @Override
    public void saveMusic(Music music) {
        if (music.getId()>0) {
            entityManager.merge(music);
        }else {
            entityManager.persist(music);
        }

    }

    @Override
    public List<Music> getAllMusic() {
      List<Music> musicList=  entityManager.createQuery("select m from Music m").getResultList();
    return musicList;
    }

    @Override
    public void deleteMusic(int id) {
        entityManager.createQuery("delete from Music m where m.id = :id").setParameter("id",id).executeUpdate();
    }

    @Override
    public Music findById(int id) {
       return entityManager.find(Music.class,id);
    }
}
