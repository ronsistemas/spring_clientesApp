
package com.ordex.dao;

import com.ordex.domain.Persona;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Ron
 */
public interface IPersonaDao extends CrudRepository<Persona, Long> {
    
}
