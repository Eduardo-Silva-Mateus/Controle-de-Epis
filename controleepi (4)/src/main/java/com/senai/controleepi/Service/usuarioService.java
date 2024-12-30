package com.senai.controleepi.Service;

import com.senai.controleepi.Dtos.loginDto;
import com.senai.controleepi.Dtos.usuarioDto;
import com.senai.controleepi.Models.UsuarioModel;
import com.senai.controleepi.Repository.usuarioRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class usuarioService {
    
    @Autowired
    usuarioRepository repository;
    
    public boolean validarLogin(loginDto loginDto){
              
        Optional<UsuarioModel> optionalUsuario = repository.findByEmail(loginDto.getEmail());
        
        //--Verifica se achou o usuário no banco de dados pelo Email
        if (!optionalUsuario.isPresent()){
            //--Se não achou retorna erro
            return false;
        }
        
        //--Se achou o usuário pelo e-mail verifica se a senha esta correta!
        if(!optionalUsuario.get().getSenha().equals(loginDto.getSenha())){
            //--Se não esta correta retorna erro
            return false;
        }        
        
        return true;
    }
    public List<usuarioDto> obterListaUsuarios(){
        
        List<UsuarioModel> listaUsuarioModel = repository.findAll();
        
        List<usuarioDto> listaUsuario = new ArrayList();
        
        for (UsuarioModel usuario : listaUsuarioModel){
            
            usuarioDto usuarioDto = new usuarioDto();
            usuarioDto.setId(usuario.getId() );
            usuarioDto.setNome(usuario.getNome());
            usuarioDto.setEmail(usuario.getEmail());
            
            listaUsuario.add(usuarioDto);
        }
        
        return listaUsuario;
        
    }
    
    public boolean cadastrarUsuario(usuarioDto cadastro){
        
        Optional<UsuarioModel> optionalUsuario = repository.findByEmail(cadastro.getEmail());
        
        if (optionalUsuario.isPresent()){
            return false;
        }
        
        UsuarioModel usuario = new UsuarioModel();
        usuario.setNome(cadastro.getNome());
        usuario.setEmail(cadastro.getEmail());
        usuario.setSenha(cadastro.getSenha());
        
        repository.save(usuario);
        
        return true;
    }
    
    public boolean excluirUsuario(Long id){
        
        System.out.println("id:" + id);
        
        Optional<UsuarioModel> optionalUsuario = repository.findById(id);
        
        if (!optionalUsuario.isPresent()){
            return false;
        }
        
        repository.delete(optionalUsuario.get());
        
        return true;
        
    }
    
    public usuarioDto obterUsuario(Long id){
        
        Optional<UsuarioModel> optionalUsuario = repository.findById(id);
        
        usuarioDto usuarioDto = new usuarioDto();
        
        if (!optionalUsuario.isPresent()){            
            usuarioDto.setId(0L);
            return usuarioDto;
        }

        usuarioDto.setId(optionalUsuario.get().getId());                
        usuarioDto.setNome(optionalUsuario.get().getNome());
        usuarioDto.setEmail(optionalUsuario.get().getEmail());        
        
        return usuarioDto;
    }
    
    public boolean atualizarUsuario(Long id, usuarioDto dados){
        
         Optional<UsuarioModel> optionalUsuario = repository.findById(id);
         
         if(!optionalUsuario.isPresent()){
             return false;
         }
         
         UsuarioModel usuario = optionalUsuario.get();
         usuario.setId(dados.getId());
         usuario.setNome(dados.getNome());
         usuario.setEmail(dados.getEmail());
         usuario.setSenha(dados.getSenha());
         
         
         repository.save(usuario);
                 
        return true;
    }
    
    
}
