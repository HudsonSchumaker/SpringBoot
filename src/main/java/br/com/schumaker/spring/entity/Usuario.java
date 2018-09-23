package br.com.schumaker.spring.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author hudsonschumaker
 */
@Document
public class Usuario {
    
    @Id
    private String id;
    private String nome;
    private Integer idade;
    private String email;

    public Usuario() {
    }
    
    public Usuario(String nome) {
        this.nome = nome;
    }
    
    public Usuario(String nome, Integer idade) {
        this.nome = nome;
        this.idade = idade;
    }
    
    public Usuario(String nome, Integer idade, String email) {
        this.nome = nome;
        this.idade = idade;
        this.email = email;
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

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", nome=" + nome + ", idade=" + idade + ", email=" + email + '}';
    }
}