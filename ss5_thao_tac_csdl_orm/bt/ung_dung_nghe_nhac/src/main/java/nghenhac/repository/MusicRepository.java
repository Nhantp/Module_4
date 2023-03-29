package nghenhac.repository;

import nghenhac.entity.Music;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
@Repository
@Transactional
public class MusicRepository implements IMusicRepository{
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public void addNew(Music music) {
        entityManager.persist(music);
    }

    @Override
    public List<Music> findAll() {
        return entityManager.createQuery("select m from Music m").getResultList();
    }

    @Override
    public void update(Music music) {
        entityManager.merge(music);
    }

    @Override
    public void delete(Music music) {
        entityManager.remove(entityManager.merge(music));
    }

    @Override
    public Music findById(int id) {
        return entityManager.find(Music.class,id);
    }
}
