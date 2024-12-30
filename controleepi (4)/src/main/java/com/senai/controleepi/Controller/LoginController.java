package com.senai.controleepi.Controller;

import com.senai.controleepi.Dtos.loginDto;
import com.senai.controleepi.Service.usuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping()
public class LoginController {
    
    @Autowired
    private usuarioService usuarioService;
    
    @GetMapping("/login")
    public String exibirLogin(Model model){
        
        loginDto loginDto = new loginDto();
        
        model.addAttribute("loginDto", loginDto);
        
        //--template : retorna o nome do arquivo html localizado lá na pasta templates.
        return "login";
    }
    
    @PostMapping("/login")
    public String realizarLogin(@ModelAttribute("loginDto") loginDto loginDto){           
        
        //--Chamar método da classe UsuarioService passando por parâmetro o Dto
        boolean acesso = usuarioService.validarLogin(loginDto);
        
        if(acesso){            
            return "redirect:home";
        }
        
        return "redirect:login?erro";
        
    } 
        
    @PostMapping("/logout")
    public String realizarLogout(){        
        return "redirect:login?logout";
    }
}
