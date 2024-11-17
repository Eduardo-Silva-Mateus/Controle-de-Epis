package com.senai.epi.Service;

import com.senai.epi.Dtos.epiDto;
import com.senai.epi.Models.epiModel;
import com.senai.epi.Repository.epiRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class epiService {
    
    @Autowired
    epiRepository repository;
    
    
    public List<epiDto> obterListaUsuarios(){
        
        List<epiModel> listaUsuarioModel = repository.findAll();
        
        List<epiDto> listaEPI = new ArrayList();
        
        for (epiModel epi : listaUsuarioModel){
            
            epiDto epiDto = new epiDto();
            epiDto.setId(epi.getId() );
            epiDto.setDescricao(epi.getDescricao());
            epiDto.setTipo(epi.getTipo());
            
            listaEPI.add(epiDto);
        }
        
        return listaEPI;
        
    }
    
    public boolean cadastrarUsuario(epiDto cadastro){
        
        Optional<epiModel> optionalUsuario = repository.findByDescricao(cadastro.getDescricao());
        
        if (optionalUsuario.isPresent()){
            return false;
        }
        
        epiModel epi = new epiModel();
        epi.setDescricao(cadastro.getDescricao());
        epi.setTipo(cadastro.getTipo());
        
        repository.save(epi);
        
        return true;
    }
    
    public boolean excluirUsuario(Long id){
        
        System.out.println("id:" + id);
        
        Optional<epiModel> optionalUsuario = repository.findById(id);
        
        if (!optionalUsuario.isPresent()){
            return false;
        }
        
        repository.delete(optionalUsuario.get());
        
        return true;
        
    }
    
    public epiDto obterUsuario(Long id){
        
        Optional<epiModel> optionalUsuario = repository.findById(id);
        
        epiDto epiDto = new epiDto();
        
        if (!optionalUsuario.isPresent()){            
            epiDto.setId(0L);
            return epiDto;
        }

        epiDto.setId(optionalUsuario.get().getId());                
        epiDto.setDescricao(optionalUsuario.get().getDescricao());
        epiDto.setTipo(optionalUsuario.get().getTipo());        
        
        return epiDto;
    }
    
    public boolean atualizarUsuario(Long id, epiDto dados){
        
         Optional<epiModel> optionalUsuario = repository.findById(id);
         
         if(!optionalUsuario.isPresent()){
             return false;
         }
         
         epiModel epi = optionalUsuario.get();
         epi.setId(dados.getId());
         epi.setDescricao(dados.getDescricao());
         epi.setTipo(dados.getTipo());
         
         
         repository.save(epi);
                 
        return true;
    }
}
