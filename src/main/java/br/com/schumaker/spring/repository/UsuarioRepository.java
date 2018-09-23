package br.com.schumaker.spring.repository;

import br.com.schumaker.spring.entity.Usuario;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author hudsonschumaker
 */
public interface UsuarioRepository extends MongoRepository<Usuario, String>{
    
    List<Usuario> findByNomeLikeIgnoreCase(String nome);
    List<Usuario> findByEmailLikeIgnoreCase(String email);

}
