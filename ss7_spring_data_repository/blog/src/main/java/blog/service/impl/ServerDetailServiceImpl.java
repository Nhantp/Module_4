package blog.service.impl;

import blog.entity.User;
import blog.entity.UserRole;
import blog.repository.IUserRepository;
import blog.repository.IUserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServerDetailServiceImpl implements UserDetailsService {
    @Autowired
    IUserRepository iUserRepository;
    @Autowired
    IUserRoleRepository iUserRoleRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = iUserRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User " + username + "not found");
        }

        List<UserRole>roleList=iUserRoleRepository.findAllByUser(user);
        List<GrantedAuthority>grantedAuthorities=new ArrayList<>();
        for (UserRole userRole: roleList) {
            grantedAuthorities.add(new SimpleGrantedAuthority(userRole.getRole().getRoleName()));
        }
        UserDetails userDetails =new org.springframework.security.core.userdetails.User(username,user.getPassword(),grantedAuthorities);
        return userDetails;
    }
}
