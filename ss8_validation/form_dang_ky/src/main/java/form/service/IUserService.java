package form.service;

import form.model.User;

import java.util.List;

public interface IUserService {
    void insert(User user);
    List<User> findAll();
}
