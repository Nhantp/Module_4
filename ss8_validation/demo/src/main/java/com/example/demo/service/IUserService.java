package form_user.service;

import form_user.model.User;

import java.util.List;

public interface IUserService {
    void insert(User user);
    List<User> findAll();
}
