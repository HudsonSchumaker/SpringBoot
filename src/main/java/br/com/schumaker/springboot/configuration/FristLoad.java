package br.com.schumaker.springboot.configuration;

import br.com.schumaker.springboot.model.entity.Perfil;
import br.com.schumaker.springboot.model.entity.Usuario;
import br.com.schumaker.springboot.model.repository.PerfilRepository;
import br.com.schumaker.springboot.model.repository.UsuarioRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.stereotype.Component;

/**
 *
 * @author hudsonschumaker
 */
@Component
public class FristLoad implements ApplicationListener<ContextRefreshedEvent>{

    @Autowired
    UsuarioRepository usuarioRepository;
    
    @Autowired
    PerfilRepository perfilRepository;
    
    @Override
    public void onApplicationEvent(ContextRefreshedEvent e) {
        List<Perfil> perfis = perfilRepository.findAll();
        if(perfis.isEmpty()){
           perfilRepository.save(new Perfil("ROLE_ADMIN"));
           Perfil perfil = perfilRepository.findByNome("ROLE_ADMIN");
           List<Perfil> perfilUsuario = new ArrayList<>();
           perfilUsuario.add(perfil);
           usuarioRepository.save(new Usuario("root", "root@root.com", "123", perfilUsuario));
        }
    }
}