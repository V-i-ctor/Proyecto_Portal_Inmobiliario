package com.proyecto.service.impl;

import com.proyecto.dao.ContactoDao;
import com.proyecto.domain.Contacto;
import com.proyecto.service.ContactoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ContactoServiceImpl implements ContactoService {

    @Autowired
    private ContactoDao contactoDao;

    @Override
    @Transactional
    public void save(Contacto contacto) {
        contactoDao.save(contacto);
    }

}
