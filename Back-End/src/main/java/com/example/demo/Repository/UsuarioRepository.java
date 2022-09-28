package com.example.demo.Repository;

import com.example.demo.Model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    public Usuario FindByUsername(String username);
    public Usuario FindByEmail(String email);
    public Usuario findByNome(String nome);

    public Usuario findByMagickey(String magickey);

    public Usuario findByEmailAndSenha(String email, String senha);

    public Usuario findByEmailAndMagickey(String email, String magickey);
}
