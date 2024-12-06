package com.senai.controleepi.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class homeController {
    
    @GetMapping
    public String exibirHome(Model model){               
        return "home";
    }
    
    @PostMapping
    public String voltarParaLogin(){
        
        //--Imprime no console do netbeans
        System.out.println("vai voltar para o login:");
        
        return "redirect:/login";
    }
}
