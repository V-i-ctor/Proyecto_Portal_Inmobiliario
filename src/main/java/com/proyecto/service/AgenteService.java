//Capa Negocio - Obtiene la lista de las agentes

package com.proyecto.service;

import com.proyecto.domain.Agente;
import java.util.List;
import org.springframework.data.repository.query.Param;


public interface AgenteService {
    
    //Se obtiene un listado de un List
    public List<Agente> getAgentes(boolean activos);
    
    //Se obtiene por medio de su id
    public Agente getAgente(Agente agente);

    //metodo salvar
    public void save(Agente agente);

    //metodo eliminar
    public void delete(Agente agente);
    
    


}
