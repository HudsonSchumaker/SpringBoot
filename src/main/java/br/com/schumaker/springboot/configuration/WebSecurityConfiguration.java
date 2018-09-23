 package br.com.schumaker.springboot.configuration;

import br.com.schumaker.springboot.model.service.MyUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 *
 * @author hudsonschumaker
 */
 @Configuration
 @EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter{
    
    @Autowired
    private MyUserDetailService myUserDetailService;
    
    @Override
    protected void configure(AuthenticationManagerBuilder amb) throws Exception {
        amb.userDetailsService(myUserDetailService);
    }
    
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
    
    @Override
    public void configure(WebSecurity security) throws Exception {
        security.ignoring().antMatchers(HttpMethod.OPTIONS, "/**")
                .antMatchers(HttpMethod.GET, "/public/**");
    }
}
