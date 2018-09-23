package br.com.schumaker.spring.controller;

import br.com.schumaker.spring.entity.Usuario;
import br.com.schumaker.spring.service.UsuarioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author hudsonschumaker
 */
@RestController
public class UsuarioController {
    
    @Autowired
    UsuarioService usuarioService;
    
    @GetMapping(value = "/usuario")
    public List<Usuario> listUsuario(){
        return usuarioService.listaUsuario();
    }
    
    @PostMapping(value = "/usuario")
    public Usuario salvarUsuario(@RequestBody Usuario usuario){
        return usuarioService.salvarUsuario(usuario);
    }
    
    @PutMapping(value = "/usuario")
    public Usuario editarUsuario(@RequestBody Usuario usuario){
        return usuarioService.salvarUsuario(usuario);
    }
    
    @DeleteMapping(value = "/usuario/{id}")
    public void deletarUsuario(@PathVariable String id){
        usuarioService.deleteUsuario(id);
    }
    
    @GetMapping(value = "/usuario/{id}")
    public Usuario getUsuario(@PathVariable String id){
        return usuarioService.getById(id);
    }
}
