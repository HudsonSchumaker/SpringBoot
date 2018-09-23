package br.com.schumaker.springboot.model.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;

/**
 *
 * @author hudsonschumaker
 */
@Document
public class Perfil implements GrantedAuthority{
    
    @Id
    private String id;
    private String nome;
    
    public Perfil(){ 
    }

    public Perfil(String nome) {
        this.nome = nome;
    }
    
    public Perfil(String id, String nome) {
        this.id = id;
        this.nome = nome;
    }
    
    @Override
    public String getAuthority() {
        return this.nome;
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Perfil{" + "id=" + id + ", nome=" + nome + '}';
    }
}