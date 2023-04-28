package blog.repository;

import blog.entity.User;
import blog.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IUserRoleRepository extends JpaRepository<UserRole,Long > {
    List<UserRole>findAllByUser(User user);

}
