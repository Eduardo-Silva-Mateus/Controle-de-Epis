package com.senai.controleepi.Controller;

import com.senai.controleepi.Dtos.ColaboradorDto;
import com.senai.controleepi.Service.ColaboradorService;
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
@RequestMapping("/colaborador")
public class ColaboradorController {
    
    @Autowired
    ColaboradorService service;
    
    @PostMapping()
    public String cadastrarUsuario(@ModelAttribute("colaborador") ColaboradorDto cadastro){
        
        boolean sucesso = service.cadastrarUsuario(cadastro);
        
        if (sucesso){
            return "redirect:listarcolaborador";
        }

        return "redirect:cadastrarcolaborador?erro";        
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<String>  excluirUsuario(@PathVariable Long id){
    
        boolean sucesso = service.excluirUsuario(id);
        
        if (sucesso){
            return ResponseEntity.ok("Colaborador excluído com sucesso.");
        }
        
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao excluir colaborador.");
        
    }
    
     @PostMapping("/{id}")
    public String atualizarContato(@ModelAttribute("colaborador") @PathVariable Long id, ColaboradorDto atualizar){
        
        boolean sucesso = service.atualizarUsuario(id,atualizar);
        
        if(sucesso){
                return "redirect:/listarcolaborador";
        }
        return "redirect:/listarcolaborador?erro";
    }
}
