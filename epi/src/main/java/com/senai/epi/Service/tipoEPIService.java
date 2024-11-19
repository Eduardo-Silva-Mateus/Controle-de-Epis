package com.senai.epi.Service;

import com.senai.epi.Dtos.epiDto;
import com.senai.epi.Dtos.tipoEpiDto;
import com.senai.epi.Models.TipoEPIModel;
import com.senai.epi.Models.epiModel;
import com.senai.epi.Repository.tipoEPIRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class tipoEPIService {
    
    @Autowired
    tipoEPIRepository repository;
    
    public List<tipoEpiDto> obterListaTipos(){
        
        List<TipoEPIModel> listaTipoEpiModel = repository.findAll();
        
        List<tipoEpiDto> listaTipoEPI = new ArrayList();
        
        for (TipoEPIModel epi : listaTipoEpiModel){
            
            tipoEpiDto tipoepiDto = new tipoEpiDto();
            tipoepiDto.setId(epi.getId() );
            tipoepiDto.setDescricao(epi.getDescricao());
            
            listaTipoEPI.add(tipoepiDto);
        }
        
        return listaTipoEPI;
        
    }
    
    public boolean cadastrarTipoEpi(epiDto cadastro){
        
        Optional<TipoEPIModel> optionalTipoEpi = repository.findByDescricao(cadastro.getDescricao());
        
        if (optionalTipoEpi.isPresent()){
            return false;
        }
        
        TipoEPIModel epi = new TipoEPIModel();
        epi.setDescricao(cadastro.getDescricao());
        
        repository.save(epi);
        
        return true;
    }
    
    public boolean excluirTipoEpi(Long id){
        
        System.out.println("id:" + id);
        
        Optional<TipoEPIModel> optionalTipoEpi = repository.findById(id);
        
        if (!optionalTipoEpi.isPresent()){
            return false;
        }
        
        repository.delete(optionalTipoEpi.get());
        
        return true;
        
    }
    
    public tipoEpiDto obterTipoEpi(Long id){
        
        Optional<TipoEPIModel> optionalTipoEpi = repository.findById(id);
        
        tipoEpiDto epiDto = new tipoEpiDto();
        
        if (!optionalTipoEpi.isPresent()){            
            epiDto.setId(0L);
            return epiDto;
        }

        epiDto.setId(optionalTipoEpi.get().getId());                
        epiDto.setDescricao(optionalTipoEpi.get().getDescricao());    
        
        return epiDto;
    }
    
    public boolean atualizarTipoEpi(Long id, tipoEpiDto dados){
        
         Optional<TipoEPIModel> optionalTipoEpi = repository.findById(id);
         
         if(!optionalTipoEpi.isPresent()){
             return false;
         }
         
         TipoEPIModel epi = optionalTipoEpi.get();
         epi.setId(dados.getId());
         epi.setDescricao(dados.getDescricao());
         
         repository.save(epi);
                 
        return true;
    }
}
