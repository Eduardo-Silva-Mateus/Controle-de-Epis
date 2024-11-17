package com.senai.epi.Repository;

import com.senai.epi.Models.UsuarioModel;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface usuarioRepository extends JpaRepository<UsuarioModel, Long>{
    
    public Optional<UsuarioModel> findByEmail(String email);
}
