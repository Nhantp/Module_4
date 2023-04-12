package form.repository;

import form.model.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
@Repository
@Transactional
public class UserRepository implements IUserRepository{
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public void insert(User user) {
        entityManager.persist(user);
    }

    @Override
    public List<User> findAll() {
        return entityManager.createQuery("select u from User u").getResultList();
    }
}
