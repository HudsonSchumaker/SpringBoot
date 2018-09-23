package br.com.schumaker.springboot.model.repository;

import br.com.schumaker.springboot.model.entity.Usuario;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author hudsonschumaker
 */
public interface UsuarioRepository extends MongoRepository<Usuario, String>{
    
    List<Usuario> findByNomeLikeIgnoreCase(String nome);
    List<Usuario> findByEmailLikeIgnoreCase(String email);
    Usuario findByEmail(String email);

}
