package com.ordex.domain;

import java.io.Serializable;
import javax.persistence.*;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.Data;

/**
 *
 * @author Ron
 */
@Data   //Proviene de lombok.Agrega constructor,los metodos setter y getter, toString, etc..para que sea un JavaBean--Ver Navigator
@Entity
@Table(name = "persona") //Evita incongruencias entre nombres de clase y de la tabla correspondiente (clase == Persona; tabla == persona)
public class Persona implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPersona;
    @NotEmpty
    private String nombre;
    
    @NotEmpty
    private String apellido;
    
    @NotEmpty
    @Email
    private String email;
    
    private String telefono;  
    
    @NotNull
    private Double saldo;
}
