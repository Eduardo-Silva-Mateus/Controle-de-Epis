package com.senai.controleepi.Controller;
 
import com.senai.controleepi.Dtos.usuarioDto;
import com.senai.controleepi.Service.usuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/visualizarusuario")
public class visualizarUsuarioController {
    
    @Autowired
    usuarioService usuarioService;
    
    @GetMapping("/{id}")
    public String exibirVisualizarUsuario(Model model, @PathVariable Long id){

        usuarioDto usuario = usuarioService.obterUsuario(id);
                
        model.addAttribute("usuario", usuario);
        
        if (usuario.getId() > 0){
            return "visualizarusuario";
        }
        
        return "redirect:/listarusuario";
        
    }
}
