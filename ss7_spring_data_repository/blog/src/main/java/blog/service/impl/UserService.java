package blog.service.impl;

import blog.entity.User;
import blog.repository.IUserRepository;
import blog.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {
    @Autowired
    IUserRepository iUserRepository;
    @Override
    public void save(User user) {
        iUserRepository.save(user);
    }

    @Override
    public User findByUsername(String userName) {
        return iUserRepository.findByUsername(userName);
    }

    @Override
    public List<User> findAll() {
        return iUserRepository.findAll();
    }


}
