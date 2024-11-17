package com.senai.epi.Service;

import com.senai.epi.Dtos.ColaboradorDto;
import com.senai.epi.Models.ColaboradorModel;
import com.senai.epi.Repository.colaboradorRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ColaboradorService {
    
    @Autowired
    colaboradorRepository repository;

    public List<ColaboradorDto> obterListaUsuarios(){
        
        List<ColaboradorModel> listaUsuarioModel = repository.findAll();
        
        List<ColaboradorDto> listaUsuario = new ArrayList();
        
        for (ColaboradorModel colaborador : listaUsuarioModel){
            
            ColaboradorDto colaboradorDto = new ColaboradorDto();
            colaboradorDto.setId(colaborador.getId() );
            colaboradorDto.setNome(colaborador.getNome());
            colaboradorDto.setEmail(colaborador.getEmail());
            colaboradorDto.setFuncao(colaborador.getFuncao());
            colaboradorDto.setNascimento(colaborador.getNascimento());
            
            listaUsuario.add(colaboradorDto);
        }
        
        return listaUsuario;
        
    }
    
    public boolean cadastrarUsuario(ColaboradorDto cadastro){
        
        Optional<ColaboradorModel> optionalColaborador = repository.findByEmail(cadastro.getEmail());
        
        if (optionalColaborador.isPresent()){
            return false;
        }
        
        ColaboradorModel colaborador = new ColaboradorModel();
        colaborador.setNome(cadastro.getNome());
        colaborador.setEmail(cadastro.getEmail());
        colaborador.setFuncao(cadastro.getFuncao());
        colaborador.setNascimento(cadastro.getNascimento());
        
        repository.save(colaborador);
        
        return true;
    }
    
    public boolean excluirUsuario(Long id){
        
        System.out.println("id:" + id);
        
        Optional<ColaboradorModel> optionalColaborador = repository.findById(id);
        
        if (!optionalColaborador.isPresent()){
            return false;
        }
        
        repository.delete(optionalColaborador.get());
        
        return true;
        
    }
    
    public ColaboradorDto obterUsuario(Long id){
        
        Optional<ColaboradorModel> optionalColaborador = repository.findById(id);
        
        ColaboradorDto colaboradorDto = new ColaboradorDto();
        
        if (!optionalColaborador.isPresent()){            
            colaboradorDto.setId(0L);
            return colaboradorDto;
        }

        colaboradorDto.setId(optionalColaborador.get().getId());                
        colaboradorDto.setNome(optionalColaborador.get().getNome());
        colaboradorDto.setEmail(optionalColaborador.get().getEmail()); 
        colaboradorDto.setFuncao(optionalColaborador.get().getFuncao());
        colaboradorDto.setNascimento(optionalColaborador.get().getNascimento());
        
        return colaboradorDto;
    }
    
    public boolean atualizarUsuario(Long id, ColaboradorDto dados){
        
         Optional<ColaboradorModel> optionalColaborador = repository.findById(id);
         
         if(!optionalColaborador.isPresent()){
             return false;
         }
         
         ColaboradorModel colaborador = optionalColaborador.get();
         colaborador.setId(dados.getId());
         colaborador.setNome(dados.getNome());
         colaborador.setEmail(dados.getEmail());
         colaborador.setFuncao(dados.getFuncao());
         colaborador.setNascimento(dados.getNascimento());
         
         
         repository.save(colaborador);
                 
        return true;
    }
}
