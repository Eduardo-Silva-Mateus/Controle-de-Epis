package com.senai.epi.Controller;

import com.senai.epi.Dtos.usuarioDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping()
public class cadastrarUsuarioController {
    
    @GetMapping("/cadastrarusuario")
    public String exibirListaUsuarios(Model model){
        
        usuarioDto cadastroDto = new usuarioDto();
        
        model.addAttribute("usuario", cadastroDto);
        
        return "cadastrarusuario";
    }
}
