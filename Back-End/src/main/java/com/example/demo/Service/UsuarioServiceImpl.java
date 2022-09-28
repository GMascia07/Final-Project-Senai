package com.example.demo.Service;


import com.example.demo.Model.Usuario;
import com.example.demo.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService{

    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario findById(Long id){
        Optional listUsuario = usuarioRepository.findById(id);
        if (!listUsuario.isEmpty()){
            return (Usuario) listUsuario.get();
        } else {
            return  new Usuario();
        }

    }

    @Override
    public Usuario findByNome
            (String nome) {
        return usuarioRepository.findByNome(nome);
    }

    @Override
    public Usuario save(Usuario usuario) {
        try {
            return usuarioRepository.save(usuario);
        } catch (Exception e){
            throw e;
        }
    }

    @Override
    public void deleteById(Long id){
        try {
            usuarioRepository.deleteById(id);
        }catch (Exception e){
            throw e;
        }
    }

    public Usuario findByEmailAndSenha(String email, String senha){
        try{
            return usuarioRepository.findByEmailAndSenha(email, senha);

        } catch (Exception e){
            throw e;
        }
    }

    @Override
    public Usuario findByEmailAndMagickey(String email, String magickey) {
        try{
            return usuarioRepository.findByEmailAndMagickey(email, magickey);
        } catch (Exception e){
            throw e;
        }
    }
}
