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

@Controller
@RequestMapping("/epi")
public class epiController {
    
    @Autowired
    epiService service;
    
    @PostMapping()
    public String cadastrarUsuario(@ModelAttribute("epi") epiDto cadastro){
        
        boolean sucesso = service.cadastrarUsuario(cadastro);
        
        if (sucesso){
            return "redirect:listarepi";
        }

        return "redirect:cadastrarepi?erro";        
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<String>  excluirUsuario(@PathVariable Long id){
    
        boolean sucesso = service.excluirUsuario(id);
        
        if (sucesso){
            return ResponseEntity.ok("Epi excluído com sucesso.");
        }
        
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao excluir epi.");
        
    }
    
     @PostMapping("/{id}")
    public String atualizarContato(@ModelAttribute("epi") @PathVariable Long id, epiDto atualizar){
        
        boolean sucesso = service.atualizarUsuario(id,atualizar);
        
        if(sucesso){
            return "redirect:/listarepi";
        }
        return "redirect:/listarepi?erro";
    }
}
