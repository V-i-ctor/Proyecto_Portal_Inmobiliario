package com.proyecto.controller;

import com.proyecto.domain.Contacto;
import com.proyecto.service.ContactoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/contacto")

public class ContactoController {

    @Autowired
    private ContactoService contactoService;
    
    @GetMapping("/vista")     
    public String inicio(Model model) {         
        var contactos = contactoService.getContactos(false);
        model.addAttribute("contactos", contactos);         
        return "/contacto/vista";     
    }
    
    @GetMapping("/nuevo")
    public String contactoNuevo(Contacto contacto){
        return "/contacto/modifica";
    }
    
    @PostMapping("/guardar")
    public String contactoGuardar(Contacto contacto, @RequestParam("imagenFile")MultipartFile imagenFile){
        contactoService.save(contacto);
        return "redirect:/contacto/vista";
    }
}
