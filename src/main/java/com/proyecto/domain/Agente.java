//Capa Datos

package com.proyecto.domain;

import lombok.Data;
import java.io.Serializable;
import jakarta.persistence.*;

//Para decir que es una clase de tipo datos y tengo una entidad en una tabla
@Data
@Entity
@Table(name="agente")

public class Agente implements Serializable{
    
    private static final long serialVersionUID = 1L; //nos permite modificar el id y poder enviar esa info para modificar, eliminar, etc
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//Nos genera el autoincremento
    @Column(name="id_agente")
            
    private Long idAgente; //El Long es una variable más grande que el int y number
    private String nombre;
    private String apellido;
    private String correo;
    private String telefono;
    private String descripcion;
    private String sitioWeb;
    private boolean activo;
    private String rutaImagen;

    
    public Agente() {     
    }     
    
    public Agente(String agente, boolean activo) 
    {         
        this.nombre = agente;         
        this.activo = activo;     
    }
 
}
