package br.com.schumaker.springboot.controller;

import br.com.schumaker.springboot.model.entity.Perfil;
import br.com.schumaker.springboot.model.service.PerfilService;
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
public class PerfilController {
    
    @Autowired
    PerfilService perfilService;
    
    @PostMapping(value = "/perfil")
    public Perfil salvarUsuario(@RequestBody Perfil perfil){
        return perfilService.salvarPerfil(perfil);
    }
    
     @GetMapping(value = "/perfil")
    public List<Perfil> listPerfil(){
        return perfilService.listaPerfil();
    }
}
