package br.com.schumaker.spring.service;

import br.com.schumaker.spring.entity.Usuario;
import br.com.schumaker.spring.repository.UsuarioRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author hudsonschumaker
 */
@Service
public class UsuarioService {
    
    @Autowired
    UsuarioRepository usuarioRepository;

    public List<Usuario> listaUsuario() {      
        return usuarioRepository.findAll();
    }

    public List<Usuario> listaUsuario(Usuario usuario) {
        usuarioRepository.save(usuario);
        return listaUsuario();
    }
}
