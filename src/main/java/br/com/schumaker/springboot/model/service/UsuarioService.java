package br.com.schumaker.springboot.model.service;

import java.util.List;
import br.com.schumaker.springboot.model.entity.Usuario;
import br.com.schumaker.springboot.model.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

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
    
    public List<Usuario> buscarPorEmail(String email){
        return usuarioRepository.findByEmailLikeIgnoreCase(email);
    }
    
    public List<Usuario> buscarPorNome(String nome){
        return usuarioRepository.findByNomeLikeIgnoreCase(nome);
    }

    public List<Usuario> listaUsuario() {      
        return usuarioRepository.findAll();
    }
    
    public Page<Usuario> listaPaginada(int page, int count) { 
        Pageable pages = new PageRequest(page, count);
        return usuarioRepository.findAll(pages);
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
