package com.pe.edu.DAWII_CL2_HuamaniTassara.model.repository;

import com.pe.edu.DAWII_CL2_HuamaniTassara.model.db.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolRepository extends JpaRepository<Rol, Integer> {
    Rol findBynomrol(String nomrol);
}
