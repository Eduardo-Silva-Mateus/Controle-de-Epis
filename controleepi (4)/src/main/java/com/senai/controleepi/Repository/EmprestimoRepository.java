package com.senai.controleepi.Repository;

import com.senai.controleepi.Models.ColaboradorModel;
import com.senai.controleepi.Models.EmprestimoModel;


import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmprestimoRepository extends JpaRepository<EmprestimoModel, Long> {
    
    public Optional<EmprestimoModel> findByColaborador(ColaboradorModel colaborador);
    
}
