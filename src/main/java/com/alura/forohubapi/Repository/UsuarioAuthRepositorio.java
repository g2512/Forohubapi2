package com.alura.forohubapi.Repository;

import com.alura.forohubapi.Entity.UsuarioAuth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UsuarioAuthRepositorio extends JpaRepository<UsuarioAuth, Long> {
    UserDetails findByLogin(String login);
}

