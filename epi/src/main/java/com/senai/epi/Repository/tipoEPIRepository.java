package com.senai.epi.Repository;

import com.senai.epi.Models.TipoEPIModel;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface tipoEPIRepository extends JpaRepository<TipoEPIModel, Long> {
    
    public Optional<TipoEPIModel> findByDescricao(String descricao);
}
