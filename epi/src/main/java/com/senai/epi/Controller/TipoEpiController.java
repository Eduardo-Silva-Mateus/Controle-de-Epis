package com.senai.epi.Controller;

import com.senai.epi.Dtos.epiDto;
import com.senai.epi.Dtos.tipoEpiDto;
import com.senai.epi.Service.tipoEPIService;
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
@RequestMapping("/tipoepi")
public class TipoEpiController {
    
    @Autowired
    tipoEPIService service;
    
    @PostMapping()
    public String cadastrarTipoEpi(@ModelAttribute("usuario") epiDto cadastro){
        
        boolean sucesso = service.cadastrarTipoEpi(cadastro);
        
        if (sucesso){
            return "redirect:listartipoepi";
        }

        return "redirect:cadastrartipoepi?erro";        
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<String>  excluirUsuario(@PathVariable Long id){
    
        boolean sucesso = service.excluirTipoEpi(id);
        
        if (sucesso){
            return ResponseEntity.ok("Usuário excluído com sucesso.");
        }
        
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao excluir usuário.");
        
    }
    
     @PostMapping("/{id}")
    public String atualizarContato(@ModelAttribute("contato") @PathVariable Long id, tipoEpiDto atualizar){
        
        boolean sucesso = service.atualizarTipoEpi(id,atualizar);
        
        if(sucesso){
            return "redirect:listartipoepi";
        }
        return "redirect:listartipoepi?erro";
    }
}
