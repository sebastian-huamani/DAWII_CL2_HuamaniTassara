package com.pe.edu.DAWII_CL2_HuamaniTassara.model.service;

import com.pe.edu.DAWII_CL2_HuamaniTassara.model.db.Rol;
import com.pe.edu.DAWII_CL2_HuamaniTassara.model.db.Usuario;
import com.pe.edu.DAWII_CL2_HuamaniTassara.model.repository.RolRepository;
import com.pe.edu.DAWII_CL2_HuamaniTassara.model.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;

@Service
@AllArgsConstructor
public class UsuarioService {
    private UsuarioRepository usuarioRepository;
    private RolRepository rolRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    public Usuario findUserByNombres(String nombres){
        return usuarioRepository.findByNomusuario(nombres);
    }

    public Usuario guardarNuevoUsuario(Usuario usuario){
        Rol usuarioRol = rolRepository.findBynomrol("ADMIN");
        usuario.setRoles(new HashSet<>(Arrays.asList(usuarioRol)));
        usuario.setNombres(usuario.getNombres());
        usuario.setApellidos(usuario.getApellidos());
        usuario.setEmail(usuario.getEmail());
        usuario.setTelefono(usuario.getTelefono());
        usuario.setNomusuario(usuario.getNomusuario());
        usuario.setPassword(bCryptPasswordEncoder.encode(usuario.getPassword()));
        usuario.setActivo(true);
        return usuarioRepository.save(usuario);
    }

}
