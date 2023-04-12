package form.service;

import form.model.User;
import form.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserService implements IUserService{
    @Autowired
    IUserRepository iUserRepository;
    @Override
    public void insert(User user) {
        iUserRepository.insert(user);
    }

    @Override
    public List<User> findAll() {
        return iUserRepository.findAll();
    }
}
