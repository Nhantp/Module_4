package codegym.vn.config;
import codegym.vn.repository.BaiHatRepository;
import codegym.vn.repository.IBaiHatRepository;
import codegym.vn.service.BaiHatService;
import codegym.vn.service.IBaiHatService;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan("codegym.vn")
public class AppConfiguration extends WebMvcConfigurerAdapter implements ApplicationContextAware {
    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Bean
    public ViewResolver internalResourceViewResolver() {
        InternalResourceViewResolver bean = new InternalResourceViewResolver();
        bean.setPrefix("/WEB-INF/view/");
        bean.setSuffix(".jsp");
        return bean;
    }

    @Bean
    public IBaiHatRepository getIBaiHatRepository() {
        return new BaiHatRepository();
    }

    @Bean
    public IBaiHatService getIBaiHatService() {
        BaiHatService service = new BaiHatService();
        service.setIBaiHatRepository(this.applicationContext.getBean(IBaiHatRepository.class));
        return service;
    }
}
