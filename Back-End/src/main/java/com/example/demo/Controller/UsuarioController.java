package com.example.demo.Controller;

import com.example.demo.Model.Usuario;
import com.example.demo.Service.UsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UsuarioController {

    @Autowired
    UsuarioServiceImpl usuarioService;

    @GetMapping("/usuario/list")
    public String findAll(Model model){
        model.addAttribute("usuarios", usuarioService.findAll());
        return "usuario/list";
    }

    @GetMapping("/usuario/add")
    public String add(Model model){
        model.addAttribute("usuario", new Usuario());
        return "usuario/add";
    }

    @GetMapping("/usuario/login")
    public String login(Model model){
        model.addAttribute("usuario", new Usuario());
        return "usuario/login";
    }

    @GetMapping("/usuario/edit/{id}")
    public String edit(Model model, @PathVariable long id){
        model.addAttribute("usuario", usuarioService.findById(id));
        return "usuario/edit";
    }

    @PostMapping("/usuario/save")
    public String save(Usuario usuario, Model model){
        try{
            usuarioService.save(usuario);
            model.addAttribute("usuario", usuario);
            model.addAttribute("isSave", true);
            return "usuario/add";
        }catch (Exception e){
            model.addAttribute("usuario", usuario);
            model.addAttribute("isError", true);
            model.addAttribute("errorMsg", e.getMessage());

            return "usuario/add";
        }
    }

    @GetMapping("/usuario/delete/{id}")
    public String delete(@PathVariable long id){
        try{
            usuarioService.deleteById(id);
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
        return "redirect:/usuario/list";
    }

    @PostMapping("/usuario/login")
    public String login(Usuario usuario, Model model) {
        try {
            System.out.println(usuario);
            Usuario u = usuarioService.findByEmailAndSenha(usuario.getEmail(), usuario.getSenha());
            System.out.println(u);
            if (u != null) {
                model.addAttribute("usuario", u);
                return "redirect:/evento/list";
            } else {
                model.addAttribute("usuario", usuario);
                model.addAttribute("isError", true);

                return "usuario/login";
            }
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
            return "login";

        }

    }
    @PostMapping("/usuario/login")
    public String recuperar (Usuario usuario, Model model) {
        try {
            System.out.println(usuario);
            Usuario u = usuarioService.findByEmailAndMagickey(usuario.getEmail(), usuario.getSenha());
            System.out.println(u);
            if (u != null) {
                model.addAttribute("usuario", u);
                return "redirect:/evento/list";
            } else {
                model.addAttribute("usuario", usuario);
                model.addAttribute("isError", true);

                return "usuario/login";
            }
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
            return "login";

        }

    }
}
