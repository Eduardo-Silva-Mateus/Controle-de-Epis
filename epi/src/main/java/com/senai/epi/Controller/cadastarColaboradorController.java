package com.senai.epi.Controller;

import com.senai.epi.Dtos.ColaboradorDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping()
public class cadastarColaboradorController {
    
    @GetMapping("/cadastrarcolaborador")
    public String exibirListaUsuarios(Model model){
        
        ColaboradorDto cadastroDto = new ColaboradorDto();
        
        model.addAttribute("colaborador", cadastroDto);
        
        return "cadastrarcolaborador";
    }
}
