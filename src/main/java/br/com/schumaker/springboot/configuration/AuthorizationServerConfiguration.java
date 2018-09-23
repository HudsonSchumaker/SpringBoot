package br.com.schumaker.springboot.configuration;

import br.com.schumaker.springboot.model.service.MyUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;

/**
 *
 * @author hudsonschumaker
 */
@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfiguration extends AuthorizationServerConfigurerAdapter{
    
    private TokenStore tokenStore = new InMemoryTokenStore();
    
    @Autowired
    @Qualifier("authenticationManagerBean")
    private AuthenticationManager authenticationManager;
    
    @Autowired
    private MyUserDetailService myUserDetailService;
    
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer asec){
        asec.tokenStore(this.tokenStore)
                .authenticationManager(this.authenticationManager)
                .userDetailsService(this.myUserDetailService);
    }
    
    @Override
    public void configure(ClientDetailsServiceConfigurer cdsc) throws Exception {
        cdsc.inMemory()
            .withClient("cliente") 
            .authorizedGrantTypes("password", "authorization_code", "refresh_token")
            .scopes("bar","read", "write")
            .refreshTokenValiditySeconds(20000)
            .accessTokenValiditySeconds(20000)
            .resourceIds("restservice")
            .secret("123");
    }
    
    @Bean
    @Primary
    public DefaultTokenServices tokenServices(){
        DefaultTokenServices defaultTokenServices = new DefaultTokenServices();
        defaultTokenServices.setSupportRefreshToken(true);
        defaultTokenServices.setTokenStore(tokenStore);
        return defaultTokenServices;
    }
}