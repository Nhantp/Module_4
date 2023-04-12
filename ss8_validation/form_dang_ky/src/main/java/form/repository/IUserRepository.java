package form.repository;

import form.model.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
public interface IUserRepository {
    void insert(User user);
    List<User>findAll();
}
