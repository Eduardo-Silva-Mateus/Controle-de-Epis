package com.senai.epi.Controller;

import com.senai.epi.Service.ColaboradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping()
public class listarColaboradorController {
    
    @Autowired
    ColaboradorService service;
    
    @GetMapping("/listarcolaborador")
    public String exibirListaUsuarios(Model model){
                     
        model.addAttribute("colaborador",service.obterListaUsuarios());
        
        //--template : retorna o nome do arquivo html localizado lá na pasta templates.
        return "listarcolaborador";
    }
}
