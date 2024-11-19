package com.senai.epi.Controller;

import com.senai.epi.Dtos.tipoEpiDto;
import com.senai.epi.Service.tipoEPIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/visualizartipoepi")
public class visualizarTipoEpiController {
    
    @Autowired
    tipoEPIService service;

    @GetMapping("/{id}")
    public String exibirVisualizarUsuario(Model model, @PathVariable Long id) {

        tipoEpiDto epi = service.obterTipoEpi(id);

        model.addAttribute("tipoepi", epi);

        if (epi.getId() > 0) {
            return "visualizartipoepi";
        }

        return "redirect:/listartipoepi";

    }
}
