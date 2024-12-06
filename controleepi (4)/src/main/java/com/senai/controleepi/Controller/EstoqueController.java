package com.senai.controleepi.Controller;

import com.senai.controleepi.Dtos.epiDto;
import com.senai.controleepi.Service.epiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller()
@RequestMapping("/estoque")
public class EstoqueController {
    
    @Autowired
    epiService service;
    
    @DeleteMapping("/{id}")
    public ResponseEntity<String>  DeletarEstoque(@PathVariable Long id){
    
        boolean sucesso = service.excluirUsuario(id);
        
        if (sucesso){
            return ResponseEntity.ok("Emprestimo excluído com sucesso.");
        }
        
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao excluir emprestimo.");
        
    }
    
     @PostMapping("/{id}")
    public String DevolverEmprestimo(@ModelAttribute("estoque") @PathVariable Long id, epiDto atualizar){
        
        boolean sucesso = service.abastecerEstoque(id,atualizar);
        
        if(sucesso){
            return "redirect:/listarestoque";
        }
        return "redirect:/listaremprestimo?erro";
    }
}
