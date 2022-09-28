package com.example.demo.Model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @Size(max = 100)
    private String nome;

    @NotNull
    @Size(max = 15)
    private String username;

    @NotNull
    @Size(max = 100)
    private String email;

    @NotNull
    private String senha;

    @NotNull
    private String magickey;

    private List<Usuario> usuarios;

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getMagicword() {
        return magickey;
    }

    public void setMagicword(String magicword) {
        this.magickey = magickey;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                ", magicword='" + magickey + '\'' +
                ", usuarios=" + usuarios +
                '}';
    }
}
