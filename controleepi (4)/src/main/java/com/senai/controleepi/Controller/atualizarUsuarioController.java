package com.senai.controleepi.Controller;

import com.senai.controleepi.Dtos.usuarioDto;
import com.senai.controleepi.Service.usuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/atualizarusuario")
public class atualizarUsuarioController {
    
    @Autowired
    usuarioService service;
    
    @GetMapping("/{id}")
    public String atualizarUsuario(Model model, @PathVariable Long id){               
        
         usuarioDto usuario = service.obterUsuario(id);
                
        model.addAttribute("usuario", usuario);
        
        if (usuario.getId() > 0){
            return "atualizarusuario";
        }
        
        return "redirect:/listarusuario";
    }
       
}
