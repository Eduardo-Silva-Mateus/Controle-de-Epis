package com.senai.epi.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "emprestimo")
public class EmprestimoModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "id_colaborador",nullable = false)
    private ColaboradorModel colaborador;
    
    @ManyToOne
    @JoinColumn(name = "id_epi",nullable = false)
    private epiModel epi;
    
    @Column(name = "dataEmprestimo")
    private LocalDate dataInicio;
    
    @Column(name = "fimEmprestimo")
    private LocalDate dataFim;

    public EmprestimoModel() {
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
