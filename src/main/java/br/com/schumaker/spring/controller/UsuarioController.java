package br.com.schumaker.spring.controller;

import br.com.schumaker.spring.entity.Usuario;
import br.com.schumaker.spring.service.UsuarioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
    public List<Usuario> listUsuario(@RequestBody Usuario usuario){
        return usuarioService.listaUsuario(usuario);
    }
}
