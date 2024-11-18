package com.senai.epi.Controller;

import com.senai.epi.Dtos.ColaboradorDto;
import com.senai.epi.Service.ColaboradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ColaboradorController {
    
    @Autowired
    ColaboradorService service;
    
    @PostMapping()
    public String cadastrarUsuario(@ModelAttribute("usuario") ColaboradorDto cadastro){
        
        boolean sucesso = service.cadastrarUsuario(cadastro);
        
        if (sucesso){
            return "redirect:listacolaborado";
        }

        return "redirect:cadastrarcolaborado?erro";        
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<String>  excluirUsuario(@PathVariable Long id){
    
        boolean sucesso = service.excluirUsuario(id);
        
        if (sucesso){
            return ResponseEntity.ok("Usuário excluído com sucesso.");
        }
        
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao excluir usuário.");
        
    }
    
     @PostMapping("/{id}")
    public String atualizarContato(@ModelAttribute("colaborador") @PathVariable Long id, ColaboradorDto atualizar){
        
        boolean sucesso = service.atualizarUsuario(id,atualizar);
        
        if(sucesso){
            return "redirect:listarcolaborador";
        }
        return "redirect:listarcolaborador?erro";
    }
}
