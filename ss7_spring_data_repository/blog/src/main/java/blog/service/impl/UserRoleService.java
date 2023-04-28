package blog.service.impl;

import blog.entity.UserRole;
import blog.repository.IUserRoleRepository;
import blog.service.IUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRoleService implements IUserRoleService{
    @Autowired
    IUserRoleRepository iUserRoleRepository;

    @Override
    public void save(UserRole userRole) {
        iUserRoleRepository.save(userRole);
    }
}
