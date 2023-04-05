package blog.repository;

import blog.entity.Category;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
@Repository
@Transactional
public class CategoryRepository implements ICategoryRepository{
    @PersistenceContext
    EntityManager entityManager;
    @Override
    public void addNew(Category category) {
        entityManager.persist(category);
    }

    @Override
    public List<Category> findAll() {
        return entityManager.createQuery("select c from Category c").getResultList();
    }

    @Override
    public void delete(Category category) {
        entityManager.remove(entityManager.merge(category));
    }

    @Override
    public Category findById(int id) {
        return entityManager.find(Category.class,id);
    }

    @Override
    public void update(Category category) {
        entityManager.merge(category);
    }
}
