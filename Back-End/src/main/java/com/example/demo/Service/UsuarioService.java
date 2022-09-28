package com.example.demo.Service;

import com.example.demo.Model.Usuario;

import java.util.List;

public interface UsuarioService {

    public List<Usuario> findAll();
    public Usuario findById(Long id);
    public Usuario findByNome(String nome);
    public Usuario save(Usuario usuario);
    public void deleteById(Long id);
    public Usuario findByEmailAndSenha(String email, String senha);
    public Usuario findByEmailAndMagickey(String email, String magickey);

}
