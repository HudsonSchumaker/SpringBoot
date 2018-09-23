package br.com.schumaker.spring.service;

import br.com.schumaker.spring.entity.Usuario;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import org.springframework.stereotype.Service;

/**
 *
 * @author hudsonschumaker
 */
@Service
public class UsuarioService {

    public List<Usuario> listaUsuario() {
        BiFunction<String, Integer, Usuario> factory = Usuario::new;

        Usuario user1 = factory.apply("Henrique Schumaker", 65);
        Usuario user2 = factory.apply("Humberto Schumaker", 63);
        Usuario user3 = factory.apply("Hugo Schumaker", 25);
        Usuario user4 = factory.apply("Hudson Schumaker", 33);
        Usuario user5 = factory.apply("Gabriel Schumaker", 35);
        Usuario user6 = factory.apply("Nikolas Schumaker", 12);
        Usuario user7 = factory.apply("Elisabeth Schumaker", 61);
        Usuario user8 = factory.apply("Eliza Schumaker", 90);
        Usuario user9 = factory.apply("Marcos Schumaker", 28);
        Usuario user10 = factory.apply("Wilson Schumaker", 93);

        List<Usuario> list = new ArrayList<>();
        list.add(user1);
        list.add(user2);
        list.add(user3);
        list.add(user4);
        list.add(user5);
        list.add(user6);
        list.add(user7);
        list.add(user8);
        list.add(user9);
        list.add(user10);
        return list;
    }

    public List<Usuario> listaUsuario(Usuario usuario) {
        List<Usuario> list = this.listaUsuario(); 
        list.add(usuario);
        return list;
    }
}
