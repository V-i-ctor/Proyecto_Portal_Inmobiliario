
package com.proyecto.controller;


import com.proyecto.domain.Agente;
import com.proyecto.service.AgenteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


@Controller
@Slf4j
@RequestMapping("/agente")
 
public class AgenteController {
    
    @Autowired
    private AgenteService agenteService;
    
    @GetMapping("/listado")     
    public String inicio(Model model) {         
        var agentes = agenteService.getAgentes(false);
        model.addAttribute("agentes", agentes);         
        return "/agente/listado";     
    }
    
    @GetMapping("/nuevo")
    public String agenteNuevo(Agente agente){
        return "/agente/modifica";
    }
    
    
    @PostMapping("/guardar")
    public String agenteGuardar(Agente agente, @RequestParam("imagenFile")MultipartFile imagenFile){
        agenteService.save(agente);
        return "redirect:/agente/listado";
    }
    @GetMapping("/eliminar/{idAgente}")
    public String agenteEliminar(Agente agente) {
        agenteService.delete(agente);
        return "redirect:/agente/listado";
    }

    @GetMapping("/modificar/{idAgente}")
    public String agenteModificar(Agente agente, Model model) {
        agente = agenteService.getAgente(agente);
        model.addAttribute("agente", agente);
        return "/agente/modifica";
    }   
}
