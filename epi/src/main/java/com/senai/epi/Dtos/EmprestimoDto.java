package com.senai.epi.Dtos;

import com.senai.epi.Models.ColaboradorModel;
import com.senai.epi.Models.UsuarioModel;
import com.senai.epi.Models.epiModel;
import java.time.LocalDate;

public class EmprestimoDto {
    
    private Long id;
    
    private ColaboradorModel colaborador;
    
    private epiModel epi;
    
    private LocalDate dataInicio;
    
    private LocalDate dataFim;

    public EmprestimoDto() {
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

    public void setUsuario(ColaboradorModel colaborador) {
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
