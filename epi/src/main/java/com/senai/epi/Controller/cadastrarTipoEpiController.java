package com.senai.epi.Controller;

import com.senai.epi.Dtos.tipoEpiDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping()
public class cadastrarTipoEpiController {
    
    @GetMapping("/cadastrartipoepi")
    public String exibirListaUsuarios(Model model){
        
        tipoEpiDto cadastroDto = new tipoEpiDto();
        
        model.addAttribute("tipoepi", cadastroDto);
        
        return "cadastrartipoepi";
    }
}
