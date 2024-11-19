package com.senai.epi.Controller;

import com.senai.epi.Dtos.epiDto;
import com.senai.epi.Dtos.tipoEpiDto;
import com.senai.epi.Service.epiService;
import com.senai.epi.Service.tipoEPIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/atualizartipoepi")
public class atualizarTipoEpiController {
    
    @Autowired
    tipoEPIService service;

    @GetMapping("/{id}")
    public String atualizarUsuario(Model model, @PathVariable Long id) {

        tipoEpiDto epi = service.obterTipoEpi(id);

        model.addAttribute("tipoepi", epi);

        if (epi.getId() > 0) {
            return "atualizartipoepi";
        }

        return "redirect:/listartipoepi";
    }
}
