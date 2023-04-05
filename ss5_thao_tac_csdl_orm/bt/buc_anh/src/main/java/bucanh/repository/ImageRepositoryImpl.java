package bucanh.repository;

import bucanh.entity.ImageOfTheDay;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
@Repository
@Transactional
public class ImageRepositoryImpl implements ImageRepository{
    @PersistenceContext
    EntityManager entityManager;
    @Override
    public List<ImageOfTheDay> findAll() {
        return entityManager.createQuery("select m from ImageOfTheDay m").getResultList();
    }

    @Override
    public void addNew(ImageOfTheDay image) {
        entityManager.persist(image);
    }

    @Override
    public ImageOfTheDay findById(int id) {
        return entityManager.find(ImageOfTheDay.class,id);
    }

    @Override
    public void update(ImageOfTheDay image) {
        entityManager.merge(image);
    }
}
