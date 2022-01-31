
package com.ordex.web;

import com.ordex.domain.Persona;
import com.ordex.service.PersonaService;
import java.util.List;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author Ron
 */
@Controller
@Slf4j
public class ControladorInicio {
    @Autowired //Similar a la anotacion de @Inject, Inyecta la interfaz correspondiente (IPersonaDao)
    private PersonaService personaService; //Tipo de objeto de interfaz

    @GetMapping("/")
    public String inicio(Model model, @AuthenticationPrincipal User user) {     
        List<Persona> personas =  personaService.listarPersona();
        Double saldoTotal = 0D;
        
        //Mostrando mensaje en consola 
        log.info("Usuario Logueado: " + user);
        
        for(Persona p: personas){
            saldoTotal += p.getSaldo();
        }
        //Enviando datos a la vista
        model.addAttribute("personas", personas);
        model.addAttribute("saldoTotal", saldoTotal);
        model.addAttribute("totalClientes", personas.size());
        
        return "index";
    }
    
    @GetMapping("/agregar")
    public String agregar(Persona persona) {
        return "modificar";
    }
    
    @PostMapping("/guardar")
    public String guardar(@Valid Persona persona, Errors errors) {
        if(errors.hasErrors()) {
            return "modificar";
        }
        personaService.guardar(persona);
        return "redirect:/";
    }
    
    @GetMapping("/editar/{idPersona}")
    public String editar(Persona persona, Model model) {
        persona = personaService.encontrarPersona(persona);
        model.addAttribute("persona", persona);
        return "modificar";
    }
    
    @GetMapping("/eliminar") //Con queryParameter (?id) se omite /{idPersona}
    public String eliminar(Persona persona) {
        personaService.eliminar(persona);
        return "redirect:/";
    }
}
