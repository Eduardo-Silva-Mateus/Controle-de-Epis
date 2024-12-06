package com.senai.controleepi.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Table(name = "epis")
public class epiModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "descricao",nullable = false)
    @NotNull
    private String descricao;
    
    @ManyToOne
    @JoinColumn(name = "descricao_tipoEpi",nullable = false)
    private TipoEPIModel tipo;
    
    @Column(name = "quantidade",nullable = false)
    private Long quantidade;
    
    private String tipoepi;
    
        
    @Override
    public String toString(){
        return tipoepi;
    }

    public Long getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Long quantidade) {
        this.quantidade = quantidade;
    } 
    
    public String getTipoepi() {
        return tipoepi;
    }

    public void setTipoepi(String tipoepi) {
        this.tipoepi = tipoepi;
    }
    
    public epiModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public TipoEPIModel getTipo() {
        return tipo;
    }

    public void setTipo(TipoEPIModel tipo) {
        this.tipo = tipo;
    }

    
    
}
