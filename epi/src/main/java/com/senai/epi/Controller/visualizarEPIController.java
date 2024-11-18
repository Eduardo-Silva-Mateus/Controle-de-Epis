package com.senai.epi.Controller;

import com.senai.epi.Dtos.ColaboradorDto;
import com.senai.epi.Dtos.epiDto;
import com.senai.epi.Service.ColaboradorService;
import com.senai.epi.Service.epiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/visualizarepi")
public class visualizarEPIController {

    @Autowired
    epiService service;

    @GetMapping("/{id}")
    public String exibirVisualizarUsuario(Model model, @PathVariable Long id) {

        epiDto epi = service.obterUsuario(id);

        model.addAttribute("epi", epi);

        if (epi.getId() > 0) {
            return "visualizarepi";
        }

        return "redirect:/listarepi";

    }

}
