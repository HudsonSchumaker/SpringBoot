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
    
    public Usuario getById(String id){
        return usuarioRepository.findOne(id);
    }

    public List<Usuario> listaUsuario() {      
        return usuarioRepository.findAll();
    }

    public Usuario salvarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }
    
    public void deleteUsuario(String id){
        usuarioRepository.delete(id);
    }
    
    public void deleteUsuario(Usuario usuario){
        usuarioRepository.delete(usuario);
    }
}
