package com.alura.forohubapi.Servicio;

import com.alura.forohubapi.Dto.PostDTO;
import com.alura.forohubapi.Dto.UsuarioDTO;
import com.alura.forohubapi.Entity.Post;
import com.alura.forohubapi.Repository.PostRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PostServicio {
    @Autowired private PostRepositorio postRepositorio;
    public PostDTO crearPost(Post post) {
        Post postGuardado = postRepositorio.save(post);
        UsuarioDTO autorDTO = new UsuarioDTO(postGuardado.getAutor().getId(), postGuardado.getAutor().getNombre(), postGuardado.getAutor().getEmail(), postGuardado.getAutor().getPassword(), null);
        return new PostDTO(postGuardado.getId(), postGuardado.getTitulo(), postGuardado.getContenido(), postGuardado.getFecha(), postGuardado.getStatus(), postGuardado.getCurso(), autorDTO);
    }

    public List<PostDTO> obtenerTodosLosPosts() {
        return postRepositorio.findAll().stream()
                .map(post -> {
                    UsuarioDTO autorDTO = new UsuarioDTO(post.getAutor().getId(), post.getAutor().getNombre(), post.getAutor().getEmail(), post.getAutor().getPassword(), null);
                    return new PostDTO(post.getId(), post.getTitulo(), post.getContenido(), post.getFecha(), post.getStatus(), post.getCurso(), autorDTO);
                })
                .collect(Collectors.toList());
    }

    public PostDTO obtenerPostPorId(Long id) {
        Post post = postRepositorio.findById(id).orElseThrow(() -> new RuntimeException("Post no encontrado"));
        UsuarioDTO autorDTO = new UsuarioDTO(post.getAutor().getId(), post.getAutor().getNombre(), post.getAutor().getEmail(), post.getAutor().getPassword(), null);
        return new PostDTO(post.getId(), post.getTitulo(), post.getContenido(), post.getFecha(), post.getStatus(), post.getCurso(), autorDTO);
    }

    public PostDTO actualizarPost(Long id, Post nuevosDatos) {
        Post postExistente = postRepositorio.findById(id).orElseThrow(() -> new RuntimeException("Post no encontrado"));

        if (nuevosDatos.getTitulo() != null && !nuevosDatos.getTitulo().isEmpty()) {
            postExistente.setTitulo(nuevosDatos.getTitulo());
        }
        if (nuevosDatos.getContenido() != null && !nuevosDatos.getContenido().isEmpty()) {
            postExistente.setContenido(nuevosDatos.getContenido());
        }
        if (nuevosDatos.getStatus() != null && !nuevosDatos.getStatus().isEmpty()) {
            postExistente.setStatus(nuevosDatos.getStatus());
        }
        if (nuevosDatos.getCurso() != null && !nuevosDatos.getCurso().isEmpty()) {
            postExistente.setCurso(nuevosDatos.getCurso());
        }

        Post postGuardado = postRepositorio.save(postExistente);
        UsuarioDTO autorDTO = new UsuarioDTO(postGuardado.getAutor().getId(), postGuardado.getAutor().getNombre(), postGuardado.getAutor().getEmail(), postGuardado.getAutor().getPassword(), null);
        return new PostDTO(postGuardado.getId(), postGuardado.getTitulo(), postGuardado.getContenido(), postGuardado.getFecha(), postGuardado.getStatus(), postGuardado.getCurso(), autorDTO);
    }

    public void eliminarPost(Long id) {
        Optional<Post> optionalPost = postRepositorio.findById(id);
        if (optionalPost.isPresent()) {
            postRepositorio.deleteById(id);
        } else {
            throw new RuntimeException("Post no encontrado");
        }
    }


}
