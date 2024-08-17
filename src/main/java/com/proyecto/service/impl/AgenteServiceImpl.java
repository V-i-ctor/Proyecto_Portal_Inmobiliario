//Capa Negocio - Implementa la lista que obtiene del agenteService

package com.proyecto.service.impl;

import com.proyecto.dao.AgenteDao;
import com.proyecto.domain.Agente;
import com.proyecto.service.AgenteService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AgenteServiceImpl implements AgenteService{
    
    @Autowired
    private AgenteDao agenteDao;
    
    @Override
    @Transactional(readOnly=true)
    public List<Agente> getAgentes(boolean activos){
        var lista=agenteDao.findAll();
        if (activos) {
           lista.removeIf(e -> !e.isActivo());
        }
        return lista;
    }
    
    @Override
    @Transactional(readOnly=true)    
    public Agente getAgente(Agente agente){
        return agenteDao.findById(agente.getIdAgente()).orElse(null);
    }
    
    //metodo guardar
    @Override
    @Transactional
    public void save(Agente agente){
        agenteDao.save(agente);
    }
    
    @Override
    @Transactional
    //metodo eliminar
    public void delete(Agente agente){
        agenteDao.delete(agente);
    }
    
    


}
