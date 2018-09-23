package br.com.schumaker.spring.controller;

import br.com.schumaker.spring.entity.Usuario;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author hudsonschumaker
 */
@RestController
public class IndexController {
    
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getText(){
        return "Olá SpringBoot !!!";
    }
    
    @RequestMapping(value = "/{nome}", method = RequestMethod.GET)
    public Usuario getText(@PathVariable String nome){
        return new Usuario(nome);
    }
}
