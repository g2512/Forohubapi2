package com.alura.forohubapi.Servicio;

import com.alura.forohubapi.Entity.UsuarioAuth;
import com.alura.forohubapi.Repository.UsuarioAuthRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class AutenticacionService implements UserDetailsService {

    @Autowired
    private UsuarioAuthRepositorio usuarioAuthRepositorio;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
       return usuarioAuthRepositorio.findByLogin(login);
    }
}


