package br.com.schumaker.spring.repository;

import br.com.schumaker.spring.entity.Perfil;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author hudsonschumaker
 */
public interface PerfilRepository extends MongoRepository<Perfil, String>{
    
}
