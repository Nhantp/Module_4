package blog.service.impl;

import blog.entity.Role;
import blog.repository.IRoleRepository;
import blog.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService implements IRoleService {
    @Autowired
    IRoleRepository iRoleRepository;

    @Override
    public List<Role> findAll() {
        return iRoleRepository.findAll();
    }

    @Override
    public Role findByRoleId(Long roleId) {
        return iRoleRepository.findByRoleId(roleId);
    }

}
