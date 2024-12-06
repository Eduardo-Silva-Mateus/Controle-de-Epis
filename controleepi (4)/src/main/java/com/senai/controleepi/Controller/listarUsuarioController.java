package com.senai.controleepi.Controller;
 
import com.senai.controleepi.Service.usuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping()
public class listarUsuarioController {
    
    @Autowired
    usuarioService usuarioService;
    
    @GetMapping("/listarusuario")
    public String exibirListaUsuarios(Model model){
                     
        model.addAttribute("usuario",usuarioService.obterListaUsuarios());
        
        //--template : retorna o nome do arquivo html localizado lá na pasta templates.
        return "listarusuario";
    }
    
}
