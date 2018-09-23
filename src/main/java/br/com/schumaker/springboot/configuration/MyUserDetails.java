package br.com.schumaker.springboot.configuration;

import br.com.schumaker.springboot.model.entity.Usuario;
import java.util.Collection;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 *
 * @author hudsonschumaker
 */
public class MyUserDetails extends Usuario implements UserDetails {

    public MyUserDetails(Usuario usuario) {
        super(usuario);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return getPerfis();
    }

    @Override
    public String getPassword() {
        return getSenha();
    }

    @Override
    public String getUsername() {
        return getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
