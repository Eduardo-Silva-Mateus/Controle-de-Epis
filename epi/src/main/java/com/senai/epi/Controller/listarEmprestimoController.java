package com.senai.epi.Controller;

import com.senai.epi.Service.EmprestimoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/listaremprestimo")
public class listarEmprestimoController {
    
    @Autowired
    EmprestimoService service;
    
    @GetMapping("/listaremprestimo")
    public String exibirListaUsuarios(Model model){
                     
        model.addAttribute("emprestimo",service.obterListaEmprestimo());
        
        //--template : retorna o nome do arquivo html localizado lá na pasta templates.
        return "listaremprestimo";
    }
}
