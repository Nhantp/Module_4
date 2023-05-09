package blog.config;

import blog.controller.AuthenticationController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    UserDetailsService service;


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // load userdetailservice do mình xây dựng để spring auth
        auth.userDetailsService(service).passwordEncoder(new BCryptPasswordEncoder());
    }

    @Bean
    public AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

////        // Đăng ký những pattern
//        http.authorizeRequests().antMatchers("/login","/register").permitAll();
//        // Đăng ký những pattern phải login với quyền user hoặc admin mới được truy cập
//        http.authorizeRequests().antMatchers("/blog", "/blog/create","/category/create").access("hasAnyRole('ROLE_USER','ROLE_ADMIN')").anyRequest().denyAll();
//        // Đăng ký những pattern phải login với quyền admin mới được truy cập
//        http.authorizeRequests().antMatchers("blog/**","category/**").hasRole("ADMIN");
//        // Trả về url nào khi user không có quyền truy cập
//        http.authorizeRequests().and().exceptionHandling().accessDeniedPage("/deny");
//        // Trường hợp user chưa đăng nhập truy cập những pattern cần quyền thì phải chuyển sang trang login
//        http.authorizeRequests().and().formLogin().loginPage("/login").defaultSuccessUrl("/blog").permitAll();
//

//        http
//                .authorizeRequests()
//                .antMatchers("/login","/register").permitAll()
//                .antMatchers("/blog", "/blog/create","/blog/search/**","/category/create","/blog/**").access("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
//                .anyRequest().denyAll()
//                .and()
//                .formLogin()
//                .loginPage("/login")
//                .defaultSuccessUrl("/blog")
//                .permitAll()
//                .and()
//                .logout()
//                .logoutUrl("/logout")
//                .logoutSuccessUrl("/")
//                .permitAll();
    }
}