package com.alura.forohubapi.Servicio;


import com.alura.forohubapi.Dto.PostDTO;
import com.alura.forohubapi.Dto.UsuarioDTO;
import com.alura.forohubapi.Entity.Usuario;
import com.alura.forohubapi.Repository.UsuarioRepositorio;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@ToString
public class UsuarioServicio {
    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    public UsuarioDTO registrarUsuario(UsuarioDTO usuarioDTO) {
        Usuario usuario = new Usuario();
        usuario.setNombre(usuarioDTO.nombre());
        usuario.setEmail(usuarioDTO.email());
        usuario.setPassword(usuarioDTO.password());
        Usuario usuarioGuardado = usuarioRepositorio.save(usuario);
        return new UsuarioDTO(usuarioGuardado.getId(), usuarioGuardado.getNombre(), usuarioGuardado.getEmail(), usuarioGuardado.getPassword(), null);
    }


    public UsuarioDTO obtenerUsuarioPorId(Long id) {
        Usuario usuario = usuarioRepositorio.findById(id).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        List<PostDTO> posts = usuario.getPosts().stream()
                .map(post -> new PostDTO(post.getId(), post.getTitulo(), post.getContenido(), post.getFecha(), post.getStatus(), post.getCurso(), null))
                .collect(Collectors.toList());
        return new UsuarioDTO(usuario.getId(), usuario.getNombre(), usuario.getEmail(), usuario.getPassword(), posts);


    }
}
