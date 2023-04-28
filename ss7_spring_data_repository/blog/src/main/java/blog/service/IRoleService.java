package blog.service;

import blog.entity.Role;

import java.util.List;

public interface IRoleService {
    List<Role>findAll();
    Role findByRoleId(Long roleId);
}
