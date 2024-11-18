package com.senai.epi.Controller;

import com.senai.epi.Dtos.ColaboradorDto;
import com.senai.epi.Service.ColaboradorService;
import com.senai.epi.Service.usuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/atualizarcolaborador")
public class atualizarColaboradorController {
    
    @Autowired
    ColaboradorService service;
    
    @GetMapping("/{id}")
    public String atualizarUsuario(Model model, @PathVariable Long id){               
        
         ColaboradorDto colaborador = service.obterUsuario(id);
                
        model.addAttribute("colaborador", colaborador);
        
        if (colaborador.getId() > 0){
            return "atualizarcolaborador";
        }
        
        return "redirect:/listarcolaborador";
    }
}
