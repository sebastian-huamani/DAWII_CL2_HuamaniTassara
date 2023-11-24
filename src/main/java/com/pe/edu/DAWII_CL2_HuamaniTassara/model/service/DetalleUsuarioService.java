package com.pe.edu.DAWII_CL2_HuamaniTassara.model.service;

import com.pe.edu.DAWII_CL2_HuamaniTassara.model.db.Rol;
import com.pe.edu.DAWII_CL2_HuamaniTassara.model.db.Usuario;
import com.pe.edu.DAWII_CL2_HuamaniTassara.model.security.UsuarioSecurity;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@Service
public class DetalleUsuarioService implements UserDetailsService {
    private UsuarioService usuarioService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioService.findUserByNombres(username);

        return autenticacionUsuario(usuario, ListarRolesxUsuario(usuario.getRoles()));
    }

    private List<GrantedAuthority> ListarRolesxUsuario(Set<Rol> listRoles){
        Set<GrantedAuthority> roles = new HashSet<GrantedAuthority>();
        for (Rol rol : listRoles){
            roles.add(new SimpleGrantedAuthority(rol.getNomrol()));
        }
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>(roles);
        return grantedAuthorities;
    }

    private UsuarioSecurity autenticacionUsuario(Usuario usuario, List<GrantedAuthority> authorities){
        UsuarioSecurity usuarioSecurity = new UsuarioSecurity(
                usuario.getNomusuario(),
                usuario.getPassword(),
                usuario.getActivo(),
                true,
                true,
                true,
                authorities
        );
        usuarioSecurity.setNomusuario(usuario.getNomusuario());
        return usuarioSecurity;
    }
}
