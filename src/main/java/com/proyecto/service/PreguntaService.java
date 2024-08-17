//Capa Negocio - Obtiene la lista de las preguntas

package com.proyecto.service;

import com.proyecto.domain.Pregunta;
import java.util.List;
import org.springframework.data.repository.query.Param;


public interface PreguntaService {
    
    //Se obtiene un listado de un List
    public List<Pregunta> getPreguntas(boolean activos);
    
    //Se obtiene por medio de su id
    public Pregunta getPregunta(Pregunta pregunta);

    //metodo salvar
    public void save(Pregunta pregunta);

    //metodo eliminar
    public void delete(Pregunta pregunta);
    
    


}
