package com.pe.edu.DAWII_CL2_HuamaniTassara.controller;

import com.pe.edu.DAWII_CL2_HuamaniTassara.model.db.Usuario;
import com.pe.edu.DAWII_CL2_HuamaniTassara.model.service.UsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
@RequestMapping("/auth")
public class RegisterController {
    private UsuarioService usuarioService;

    @GetMapping("/register")
    public String register(){
        return "/auth/frmRegister";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute Usuario usuario){
        usuarioService.guardarNuevoUsuario(usuario);
        return "/auth/frmLogin";
    }
}
