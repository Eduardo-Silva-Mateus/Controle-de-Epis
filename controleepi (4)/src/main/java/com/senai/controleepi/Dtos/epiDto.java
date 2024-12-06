package com.senai.controleepi.Dtos;

import com.senai.controleepi.Models.TipoEPIModel;

public class epiDto {

    private Long id;
    
    private String descricao;
    
    private TipoEPIModel tipo;

    private String tipoepi;
    
    private Long quantidade;

    public String getTipoepi() {
        return tipoepi;
    }

    public void setTipoepi(String tipoepi) {
        this.tipoepi = tipoepi;
    }
    
    
    public epiDto() {
    }

    public Long getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Long quantidade) {
        this.quantidade = quantidade;
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
