package com.senai.controleepi.Controller;

import com.senai.controleepi.Dtos.EmprestimoDto;
import com.senai.controleepi.Dtos.usuarioDto;
import com.senai.controleepi.Service.EmprestimoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/devolveremprestimo")
public class devolverEmprestimoController {

    @Autowired
    EmprestimoService service;

    @GetMapping("/{id}")
    public String exibirListaUsuarios(Model model, @PathVariable Long id) {

        EmprestimoDto emprestimo = service.obterEmprestimoDevolucao(id);

        model.addAttribute("emprestimo", emprestimo);

        if (emprestimo.getId() > 0) {
            return "devolveremprestimo";
        }

        return "redirect:/listaremprestimo";

    }
}
