package com.senai.controleepi.Dtos;

import com.senai.controleepi.Models.ColaboradorModel;
import com.senai.controleepi.Models.epiModel;
import java.time.LocalDate;
import lombok.ToString;

public class EmprestimoDto {
    
    private Long id;
    
    private ColaboradorModel colaborador;
    
    private String nomeColaborador;
    
    private epiModel epi;
    
    private String descricaoEpi;
    
    private LocalDate dataInicio;
    
    private LocalDate dataFim;
    
    public EmprestimoDto() {
    }

    public String getDescricaoEpi() {
        return descricaoEpi;
    }

    public void setDescricaoEpi(String descricaoEpi) {
        this.descricaoEpi = descricaoEpi;
    }

    

    public String getNomeColaborador() {
        return nomeColaborador;
    }

    public void setNomeColaborador(String nomeColaborador) {
        this.nomeColaborador = nomeColaborador;
    }
    
    
    
    
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ColaboradorModel getColaborador() {
        return colaborador;
    }

    public void setColaborador(ColaboradorModel colaborador) {
        this.colaborador = colaborador;
    }

    public epiModel getEpi() {
        return epi;
    }

    public void setEpi(epiModel epi) {
        this.epi = epi;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataFim() {
        return dataFim;
    }

    public void setDataFim(LocalDate dataFim) {
        this.dataFim = dataFim;
    }
    
    
}
