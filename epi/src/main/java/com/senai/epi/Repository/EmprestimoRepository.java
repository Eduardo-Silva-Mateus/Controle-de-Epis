package com.senai.epi.Repository;

import com.senai.epi.Models.ColaboradorModel;
import com.senai.epi.Models.EmprestimoModel;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmprestimoRepository extends JpaRepository<EmprestimoModel, Long> {
    
    public Optional<EmprestimoModel> findByColaborador(ColaboradorModel colaborador);
    
}
