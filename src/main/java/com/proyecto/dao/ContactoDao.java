package com.proyecto.dao;

import com.proyecto.domain.Contacto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactoDao extends JpaRepository <Contacto, Long >{
    
}
