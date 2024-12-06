package com.senai.controleepi.Repository;

import com.senai.controleepi.Models.TipoEPIModel;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface tipoEPIRepository extends JpaRepository<TipoEPIModel, Long> {
    
    public Optional<TipoEPIModel> findByDescricao(String descricao);
}
