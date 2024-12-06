package com.senai.controleepi.Service;

import com.senai.controleepi.Dtos.epiDto;
import com.senai.controleepi.Models.epiModel;
import com.senai.controleepi.Repository.epiRepository;
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
            epiDto.setQuantidade(epi.getQuantidade());
            epiDto.setTipoepi(epi.getTipo().getDescricao());
            
            listaEPI.add(epiDto);
        }
        
        return listaEPI;
        
    }
    
    public List<epiDto> obterListaEstoque(){
        
        List<epiModel> listaUsuarioModel = repository.findAll();
        
        List<epiDto> listaEPI = new ArrayList();
        
        for (epiModel epi : listaUsuarioModel){
            
            epiDto epiDto = new epiDto();
            epiDto.setId(epi.getId() );
            epiDto.setDescricao(epi.getDescricao());
            epiDto.setQuantidade(epi.getQuantidade());
            
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
        epi.setQuantidade(cadastro.getQuantidade());
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
    
    public epiDto obterEstoque(Long id){
        
        Optional<epiModel> optionalUsuario = repository.findById(id);
        
        epiDto epiDto = new epiDto();
        
        if (!optionalUsuario.isPresent()){            
            epiDto.setId(0L);
            return epiDto;
        }

        epiDto.setId(optionalUsuario.get().getId());                
        epiDto.setQuantidade(optionalUsuario.get().getQuantidade());
        epiDto.setDescricao(optionalUsuario.get().getDescricao());        
        
        return epiDto;
    }
    
       public ArrayList<epiDto> obterDescricao() {
    // Obtém a lista de epiModel do repositório
    List<epiModel> listaDescricaoModel = repository.findAll();
    
    // Inicializa uma lista para armazenar os objetos epiDto
    ArrayList<epiDto> listaEPI = new ArrayList<>();
    
    // Itera sobre os objetos epiModel
    for (epiModel epi : listaDescricaoModel) {
        // Cria um novo objeto epiDto e define os valores necessários
        epiDto epiDto = new epiDto();
        epiDto.setId(epi.getId());
        epiDto.setTipo(epi.getTipo());
        
        // Adiciona o epiDto à lista
        listaEPI.add(epiDto);
    }
    
    // Retorna a lista de epiDto
    return listaEPI;
}
       public ArrayList<epiDto> obterListaTipos() {
    // Obtém a lista de epiModel do repositório
    List<epiModel> listaDescricaoModel = repository.findAll();
    
    // Inicializa uma lista para armazenar os objetos epiDto
    ArrayList<epiDto> listaEPI = new ArrayList<>();
    
    // Itera sobre os objetos epiModel
    for (epiModel epi : listaDescricaoModel) {
        // Cria um novo objeto epiDto e define os valores necessários
        epiDto epiDto = new epiDto();
        epiDto.setId(epi.getId());
        epiDto.setDescricao(epi.getDescricao());
        
        // Adiciona o epiDto à lista
        listaEPI.add(epiDto);
    }
    
    // Retorna a lista de epiDto
    return listaEPI;
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
    public boolean abastecerEstoque(Long id, epiDto dados){
        
         Optional<epiModel> optionalUsuario = repository.findById(id);
         
         if(!optionalUsuario.isPresent()){
             return false;
         }
         
         epiModel epi = optionalUsuario.get();
         epi.setId(dados.getId());
         epi.setDescricao(dados.getDescricao());
         epi.setQuantidade(dados.getQuantidade());         
         
         repository.save(epi);
                 
        return true;
    }
}
