package com.senai.controleepi.Controller;

import com.senai.controleepi.Dtos.EmprestimoDto;
import com.senai.controleepi.Service.EmprestimoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/emprestimo")
public class EmprestimoController {
    
    @Autowired
    EmprestimoService service;
    
    @PostMapping()
    public String cadastrarEmprestimo(@ModelAttribute("emprestimo") EmprestimoDto cadastro){
        
        boolean sucesso = service.cadastrarEmprestimo(cadastro);
        
        if (sucesso){
            return "redirect:listaremprestimo";
        }

        return "redirect:cadastraremprestimo?erro";        
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<String>  DeletarEmprestimo(@PathVariable Long id){
    
        boolean sucesso = service.excluirEmprestimo(id);
        
        if (sucesso){
            return ResponseEntity.ok("Emprestimo excluído com sucesso.");
        }
        
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao excluir emprestimo.");
        
    }
    
     @PostMapping("/{id}")
    public String DevolverEmprestimo(@ModelAttribute("emprestimo") @PathVariable Long id, EmprestimoDto atualizar){
        
        boolean sucesso = service.DevolverEmprestimo(id,atualizar);
        
        if(sucesso){
            return "redirect:/listaremprestimo";
        }
        return "redirect:/listaremprestimo?erro";
    }
}
