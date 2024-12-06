package com.senai.controleepi.Repository;

import com.senai.controleepi.Models.UsuarioModel;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface usuarioRepository extends JpaRepository<UsuarioModel, Long>{
    
    public Optional<UsuarioModel> findByEmail(String email);
}
