package blog.service;

import blog.entity.User;
import blog.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService{
    @Autowired
    IUserRepository iUserRepository;
    @Override
    public void save(User user) {
        iUserRepository.save(user);
    }

    @Override
    public User findByUserName(String userName) {
        return iUserRepository.findByUserName(userName);
    }
}
