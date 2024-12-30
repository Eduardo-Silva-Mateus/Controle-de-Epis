package com.senai.controleepi.Repository;

import com.senai.controleepi.Models.epiModel;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface epiRepository extends JpaRepository<epiModel, Long>{
    
    public Optional<epiModel> findByDescricao(String descricao);
    
}
