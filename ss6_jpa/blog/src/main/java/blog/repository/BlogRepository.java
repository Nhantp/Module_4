package blog.repository;

import blog.entity.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class BlogRepository implements IBlogRepository{
    @PersistenceContext
    private EntityManager entityManager;
    @Autowired
    IBlogRepository iBlogRepository;
    @Override
    public void addNew(Blog blog) {
        entityManager.persist(blog);
    }

    @Override
    public List<Blog> findAll() {
        return entityManager.createQuery("select b from Blog b").getResultList();
    }

    @Override
    public Blog findById(int id) {
        return entityManager.find(Blog.class,id);
    }

    @Override
    public void update(Blog blog) {
        entityManager.merge(blog);
    }
}
