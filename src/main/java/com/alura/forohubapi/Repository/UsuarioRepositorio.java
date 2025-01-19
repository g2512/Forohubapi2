package com.alura.forohubapi.Repository;
import com.alura.forohubapi.Entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepositorio extends JpaRepository<Usuario,Long>{
    Usuario findByEmail (String email);
}
