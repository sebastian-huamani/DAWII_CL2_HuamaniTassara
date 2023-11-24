package com.pe.edu.DAWII_CL2_HuamaniTassara.controller;


import com.pe.edu.DAWII_CL2_HuamaniTassara.model.security.UsuarioSecurity;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/auth")
@Controller
@AllArgsConstructor
public class LoginController {

    @GetMapping("/login")
    public String login(){
        return "/auth/frmLogin";
    }

    @GetMapping("/login-success")
    public String loginSuccess(){
        return "redirect:/auth/dashboard";
    }

    @GetMapping("/dashboard")
    public String dashboard(HttpServletRequest request){
        HttpSession session =  request.getSession();
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        UsuarioSecurity usuarioSecurity = (UsuarioSecurity) userDetails;

        session.setAttribute("usuario", usuarioSecurity);
        System.out.println(userDetails.getAuthorities());
        return "dashboard";
    }
}
