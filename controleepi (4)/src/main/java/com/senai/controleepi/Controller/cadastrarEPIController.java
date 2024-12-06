package com.senai.controleepi.Controller;

import com.senai.controleepi.Dtos.epiDto;
import com.senai.controleepi.Dtos.tipoEpiDto;
import com.senai.controleepi.Repository.tipoEPIRepository;
import com.senai.controleepi.Service.tipoEPIService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping()
public class cadastrarEPIController {
    
    @Autowired
    tipoEPIService tipoEPIService;
    
    @GetMapping("/cadastrarepi")
    public String exibirListaUsuarios(Model model){
        
        
        List<tipoEpiDto> tipoepi = tipoEPIService.obterListaTipos();
        
        epiDto cadastroDto = new epiDto();
        
        model.addAttribute("epi", cadastroDto);
                
        model.addAttribute("tipoepi", tipoepi);
        
        return "cadastrarepi";
    }
}
