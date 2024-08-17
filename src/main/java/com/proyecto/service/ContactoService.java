
package com.proyecto.service;

import com.proyecto.domain.Contacto;
import java.util.List;

public interface ContactoService {
    
    //Se obtiene un listado de un List
    public List<Contacto> getContactos(boolean activos);
    
    //Se obtiene por medio de su id
    public Contacto getContacto(Contacto contacto);
    
    public void save(Contacto contacto);

}
