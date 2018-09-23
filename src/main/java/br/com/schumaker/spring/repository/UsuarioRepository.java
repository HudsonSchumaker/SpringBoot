package br.com.schumaker.spring.repository;

import br.com.schumaker.spring.entity.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author hudsonschumaker
 */
public interface UsuarioRepository extends MongoRepository<Usuario, String>{
    
}
