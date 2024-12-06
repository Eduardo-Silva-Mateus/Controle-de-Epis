package com.senai.controleepi.Controller;

import com.senai.controleepi.Dtos.epiDto;
import com.senai.controleepi.Service.epiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller()
@RequestMapping("/atualizarestoque")
public class atualizarEstoqueController {
    
    @Autowired
    epiService service;

    @GetMapping("/{id}")
    public String atualizarUsuario(Model model, @PathVariable Long id) {

        epiDto epi = service.obterEstoque(id);

        model.addAttribute("estoque", epi);

        if (epi.getId() > 0) {
            return "atualizarestoque";
        }

        return "redirect:/listarestoque";
    }
}
