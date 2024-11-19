package com.senai.epi.Service;

import com.senai.epi.Dtos.EmprestimoDto;
import com.senai.epi.Models.EmprestimoModel;
import com.senai.epi.Repository.EmprestimoRepository;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmprestimoService {
    
    @Autowired
    EmprestimoRepository repository;
    
    public boolean cadastrarEmprestimo(EmprestimoDto cadastro){
        
        Optional<EmprestimoModel> optionalMunicipio = repository.findByColaborador(cadastro.getColaborador());
        
        if (optionalMunicipio.isPresent()){
            return false;
        }
        
        EmprestimoModel emprestimo = new EmprestimoModel();
        
        emprestimo.setColaborador(cadastro.getColaborador());
        emprestimo.setEpi(cadastro.getEpi());
        emprestimo.setDataInicio(LocalDate.now());
        
        repository.save(emprestimo);
        
        return true;
    }
      public List<EmprestimoDto> obterListaEmprestimo(){

            List<EmprestimoModel> listaMunicipioModel = repository.findAll();

            List<EmprestimoDto> listaMunicipio = new ArrayList();

            for (EmprestimoModel emprestimo : listaMunicipioModel){

                EmprestimoDto emprestimoDto = new EmprestimoDto();
                emprestimoDto.setId(emprestimo.getId() );
                emprestimoDto.setUsuario(emprestimo.getColaborador());
                emprestimoDto.setEpi(emprestimo.getEpi());

                listaMunicipio.add(emprestimoDto);
            }

            return listaMunicipio;

        }
      
      public boolean excluirEmprestimo(Long id){
        
        System.out.println("id:" + id);
        
        Optional<EmprestimoModel> optionalEmprestimo = repository.findById(id);
        
        if (!optionalEmprestimo.isPresent()){
            return false;
        }
        
        repository.delete(optionalEmprestimo.get());
        
        return true;
        
    }
      
      public boolean DevolverEmprestimo(Long id, EmprestimoDto dados){
        
         Optional<EmprestimoModel> optionalUsuario = repository.findById(id);
         
         if(!optionalUsuario.isPresent()){
             return false;
         }
         
         EmprestimoModel emprestimo = optionalUsuario.get();
         
         emprestimo.setDataFim(LocalDate.now());
         
         repository.save(emprestimo );
                 
        return true;
    }
      
}
