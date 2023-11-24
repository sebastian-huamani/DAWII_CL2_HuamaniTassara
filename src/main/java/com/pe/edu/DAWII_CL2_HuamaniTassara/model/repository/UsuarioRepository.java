package com.pe.edu.DAWII_CL2_HuamaniTassara.model.repository;

import com.pe.edu.DAWII_CL2_HuamaniTassara.model.db.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository  extends JpaRepository<Usuario, Integer> {
    Usuario findByNomusuario(String nomusuario);
}
