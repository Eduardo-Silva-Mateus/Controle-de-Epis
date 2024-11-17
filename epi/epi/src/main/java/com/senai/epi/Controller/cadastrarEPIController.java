package com.senai.epi.Controller;

import com.senai.epi.Dtos.epiDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping()
public class cadastrarEPIController {
    
    @GetMapping("/cadastrarepi")
    public String exibirListaUsuarios(Model model){
        
        epiDto cadastroDto = new epiDto();
        
        model.addAttribute("epi", cadastroDto);
        
        return "cadastrarepi";
    }
}
