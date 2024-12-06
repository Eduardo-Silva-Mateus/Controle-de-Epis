package com.senai.controleepi.Controller;
 
import com.senai.controleepi.Dtos.ColaboradorDto;
import com.senai.controleepi.Service.ColaboradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/visualizarcolaborador")
public class visualizarColaboradorController {
    
    @Autowired
    ColaboradorService service;
    
    @GetMapping("/{id}")
    public String exibirVisualizarUsuario(Model model, @PathVariable Long id){

        ColaboradorDto colaborador = service.obterUsuario(id);
                
        model.addAttribute("colaborador", colaborador);
        
        if (colaborador.getId() > 0){
            return "visualizarcolaborador";
        }
        
        return "redirect:/listarcolaborador";
        
    }
}
