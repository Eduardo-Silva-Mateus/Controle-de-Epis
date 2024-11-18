package com.senai.epi.Repository;

import com.senai.epi.Models.ColaboradorModel;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface colaboradorRepository extends JpaRepository<ColaboradorModel, Long>{
    
    public Optional<ColaboradorModel> findByEmail(String email);
    
}
