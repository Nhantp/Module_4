package blog.repository;

import blog.entity.User;
import blog.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IUserRepository extends JpaRepository<User,Long> {
    User findByUsername(String userName);
}
