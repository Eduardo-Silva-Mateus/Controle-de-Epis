package com.senai.controleepi.Controller;

import com.senai.controleepi.Dtos.ColaboradorDto;
import com.senai.controleepi.Dtos.EmprestimoDto;
import com.senai.controleepi.Dtos.epiDto;
import com.senai.controleepi.Dtos.tipoEpiDto;
import com.senai.controleepi.Service.ColaboradorService;
import com.senai.controleepi.Service.epiService;
import com.senai.controleepi.Service.tipoEPIService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping()
public class cadastrarEmprestimoController {

    @Autowired
    epiService tipoEPIService;
    
    @Autowired
    ColaboradorService ColaboradorService;
            
    @GetMapping("/cadastraremprestimo")
    public String exibirListaUsuarios(Model model) {

        EmprestimoDto cadastroDto = new EmprestimoDto();
        
            // Lista de equipamentos (tipoepi)
        List<epiDto> epi = tipoEPIService.obterListaTipos();
    // Lista de colaboradores
        List<ColaboradorDto> colaboradores = ColaboradorService.obterListaColaboradores();
        
        model.addAttribute("emprestimo", cadastroDto);
        model.addAttribute("epis", epi);
        model.addAttribute("colaboradores", colaboradores);

        return "cadastraremprestimo";
    }
}
