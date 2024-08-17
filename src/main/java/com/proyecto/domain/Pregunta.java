//Capa Datos

package com.proyecto.domain;

import lombok.Data;
import java.io.Serializable;
import jakarta.persistence.*;

//Para decir que es una clase de tipo datos y tengo una entidad en una tabla
@Data
@Entity
@Table(name="preguntas_frecuentes")

public class Pregunta implements Serializable{
    
    private static final long serialVersionUID = 1L; //nos permite modificar el id y poder enviar esa info para modificar, eliminar, etc
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//Nos genera el autoincremento
    @Column(name="id_pregunta")
            
    private Long idPregunta; //El Long es una variable más grande que el int y number
    private String pregunta;
    private String respuesta;
    private boolean activo;

    
    public Pregunta() {     
    }     
    
    public Pregunta(String pregunta, boolean activo) 
    {         
        this.pregunta = pregunta;         
        this.activo = activo;     
    }
 
}
