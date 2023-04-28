package blog.controller;

import blog.entity.Role;
import blog.entity.User;
import blog.entity.UserRole;
import blog.repository.IRoleRepository;
import blog.repository.IUserRepository;
import blog.repository.IUserRoleRepository;
import blog.service.IRoleService;
import blog.service.IUserRoleService;
import blog.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
@Controller
//@RequestMapping("/authen")
public class AuthenticationController {
    @Autowired
    private IUserService iUserService;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private IRoleService iRoleService;
    @Autowired
    IUserRoleService iUserRoleService;
    Role role;

    @GetMapping("register")
    public String showRegister(Model model) {
        model.addAttribute("user",new User());
        return "/register";
    }
    @PostMapping("register")
    public String doRegister(@ModelAttribute("user") User user) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        user.setPassword(encoder.encode(user.getPassword()));
        Role role = iRoleService.findByRoleId(2L);
        UserRole userRole=new UserRole();
        userRole.setUser(user);
        userRole.setRole(role);
        iUserService.save(user);
        iUserRoleService.save(userRole);
        return "redirect:/login";
    }


    @GetMapping("/login")
    public String showLogin(Model model) {
        model.addAttribute("user",new User());
        return "/login";
    }
    @PostMapping("/login")
    public String doLogin(@RequestParam("username") String username,
                          @RequestParam("password") String password){

        Authentication authentication=new UsernamePasswordAuthenticationToken(username,password);
        authentication=authenticationManager.authenticate(authentication);

        SecurityContextHolder.getContext().setAuthentication(authentication);
        return "redirect:/blog";
    }
//    @GetMapping("/deny")
//    public String deny(){
//        return "deny";
//    }
//    @GetMapping("/addRole")
//    public String role(Model model){
//        model.addAttribute("userRole",new UserRole());
//        model.addAttribute("users",iUserService.findAll());
//        model.addAttribute("roles",iRoleService.findAll());
//        return "addRole";
//    }
//    @PostMapping("addRole")
//    public String doRole(@ModelAttribute("userRole") UserRole role){
//        iUserRoleService.save(role);
//        return "index";
//    }

}
