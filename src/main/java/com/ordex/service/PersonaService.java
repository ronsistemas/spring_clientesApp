
package com.ordex.service;

import com.ordex.domain.Persona;
import java.util.List;

/**
 *
 * @author Ron
 */
public interface PersonaService {
    public List<Persona> listarPersona();
    
    public void guardar(Persona persona);
    public void eliminar(Persona persona);
    public Persona encontrarPersona(Persona persona);
}
