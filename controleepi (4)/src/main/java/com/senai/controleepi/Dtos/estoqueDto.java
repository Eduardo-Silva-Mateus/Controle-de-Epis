package com.senai.controleepi.Dtos;


import com.senai.controleepi.Models.EmprestimoModel;
import com.senai.controleepi.Models.epiModel;
import java.time.LocalDate;
import lombok.Data;

public class estoqueDto {
    
    private Long id;
        
    private epiModel quantidade;
    
    private Long quantidadeEpi;
    
    private LocalDate data;

 
    public estoqueDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public epiModel getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(epiModel quantidade) {
        this.quantidade = quantidade;
    }

    public Long getQuantidadeEpi() {
        return quantidadeEpi;
    }

    public void setQuantidadeEpi(Long quantidadeEpi) {
        this.quantidadeEpi = quantidadeEpi;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }
    
    
    
    
}
