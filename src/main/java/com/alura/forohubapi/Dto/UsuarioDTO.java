package com.alura.forohubapi.Dto;

import com.alura.forohubapi.Entity.Usuario;

import java.util.List;

public record UsuarioDTO (Long id, String nombre, String email, String password, List<PostDTO> posts
        ){
        public Usuario toEntity() {
                return null;
        }
}
