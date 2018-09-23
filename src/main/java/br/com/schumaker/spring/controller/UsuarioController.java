package br.com.schumaker.spring.controller;

import br.com.schumaker.spring.entity.Usuario;
import br.com.schumaker.spring.service.UsuarioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
    
    @GetMapping(value = "/usuario/{id}")
    public Usuario getUsuario(@PathVariable String id){
        return usuarioService.getById(id);
    }
    
    @GetMapping(value = "/usuario/{nome}/nome")
    public List<Usuario> getUsuarioPorNome(@PathVariable String nome){
        return usuarioService.buscarPorNome(nome);
    }
    
    @GetMapping(value = "/usuario/{email}/email")
    public List<Usuario> getUsuarioPorEmail(@PathVariable String email){
        return usuarioService.buscarPorEmail(email);
    }
    
    @GetMapping(value = "/usuario")
    public List<Usuario> listUsuario(){
        return usuarioService.listaUsuario();
    }
    
    @GetMapping(value = "/usuario/{page}/{count}")
    public Page<Usuario> listaPaginada(@PathVariable int page, @PathVariable int count){
        return usuarioService.listaPaginada(page, count);
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
}