
package com.proyecto.domain;

import lombok.Data;
import java.io.Serializable;
import jakarta.persistence.*;

@Data
@Entity
@Table (name="contacto")

public class Contacto implements Serializable{
    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_contacto")

    private Long idContacto;
    private String nombre;
    private String apellido;
    private String correo;
    private String telefono;
    private String mensajeContacto;
    private boolean activo;

    public Contacto() {
    }

    public Contacto(String contacto, boolean activo) 
    {         
        this.nombre = contacto;         
        this.activo = activo;     
    }
}
