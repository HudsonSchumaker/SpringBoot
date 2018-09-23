package br.com.schumaker.springboot.model.repository;

import br.com.schumaker.springboot.model.entity.Perfil;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author hudsonschumaker
 */
public interface PerfilRepository extends MongoRepository<Perfil, String>{
    
    Perfil findByNome(String role);
}
