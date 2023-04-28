package blog.service;

import blog.entity.User;
import blog.repository.IUserRepository;

import java.util.List;

public interface IUserService {
    void save(User user);
    User findByUsername(String userName);
    List<User> findAll();
}
