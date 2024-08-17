
package com.proyecto.controller;


import com.proyecto.domain.Pregunta;
import com.proyecto.service.PreguntaService;
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
@RequestMapping("/pregunta")
 
public class PreguntasController {
    
    @Autowired
    private PreguntaService preguntaService;
    
    @GetMapping("/vista")     
    public String inicio(Model model) {         
        var preguntas = preguntaService.getPreguntas(false);
        model.addAttribute("preguntas", preguntas);         
        return "/pregunta/vista";     
    }
    
    @GetMapping("/nuevo")
    public String preguntaNuevo(Pregunta pregunta){
        return "/pregunta/modifica";
    }
    
    
    @PostMapping("/guardar")
    public String preguntaGuardar(Pregunta pregunta, @RequestParam("imagenFile")MultipartFile imagenFile){
        preguntaService.save(pregunta);
        return "redirect:/pregunta/vista";
    }
    @GetMapping("/eliminar/{idPregunta}")
    public String preguntaEliminar(Pregunta pregunta) {
        preguntaService.delete(pregunta);
        return "redirect:/pregunta/vista";
    }

    @GetMapping("/modificar/{idPregunta}")
    public String preguntaModificar(Pregunta pregunta, Model model) {
        pregunta = preguntaService.getPregunta(pregunta);
        model.addAttribute("pregunta", pregunta);
        return "/pregunta/modifica";
    }   
}
