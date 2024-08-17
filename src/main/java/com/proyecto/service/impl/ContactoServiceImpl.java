package com.proyecto.service.impl;

import com.proyecto.dao.ContactoDao;
import com.proyecto.domain.Contacto;
import com.proyecto.service.ContactoService;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ContactoServiceImpl implements ContactoService {

    @Autowired
    private ContactoDao contactoDao;

    @Override
    @Transactional(readOnly=true)
    public List<Contacto> getContactos(boolean activos){
        var lista=contactoDao.findAll();
        if (activos) {
           lista.removeIf(e -> !e.isActivo());
        }
        return lista;
    }
    
    @Override
    @Transactional(readOnly=true)    
    public Contacto getContacto(Contacto contacto){
        return contactoDao.findById(contacto.getIdContacto()).orElse(null);
    }
    
    @Override
    @Transactional
    public void save(Contacto contacto) {
        contactoDao.save(contacto);
    }

}
