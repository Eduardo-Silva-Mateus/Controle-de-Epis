package com.senai.controleepi.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDate;
import lombok.Data;

@Entity
@Data
@Table(name = "emprestimo")
public class EmprestimoModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "nome_colaborador",nullable = false)
    private ColaboradorModel colaborador;
    
    @ManyToOne
    @JoinColumn(name = "descricao_epi",nullable = false)
    private epiModel epi;
    
    @Column(name = "dataEmprestimo")
    private LocalDate dataInicio;
    
    @Column(name = "fimEmprestimo")
    private LocalDate dataFim;
    
    private String nome;
    
    private String nomeEpi;
    
    public EmprestimoModel() {
    }
    
    
}