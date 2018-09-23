package br.com.schumaker.springboot.model.service;

import br.com.schumaker.springboot.configuration.MyUserDetails;
import br.com.schumaker.springboot.model.entity.Usuario;
import br.com.schumaker.springboot.model.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author hudsonschumaker
 */
@Service
public class MyUserDetailService implements UserDetailsService{
    
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByEmail(email);
        if(null == usuario ){
            throw new UsernameNotFoundException("Usuario ou senha incorretos");
        }
        return new MyUserDetails(usuario);
    }
    
}
