package com.alura.forohubapi.Controlador;

import com.alura.forohubapi.Dto.PostDTO;
import com.alura.forohubapi.Entity.Post;
import com.alura.forohubapi.Entity.Usuario;
import com.alura.forohubapi.Servicio.PostServicio;
import com.alura.forohubapi.Servicio.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/posts")
public class PostControlador {
    @Autowired
    private PostServicio postServicio;
    @Autowired UsuarioServicio usuarioServicio;

    @PostMapping("/crear")
    public PostDTO crearPost(@RequestBody Post post, @RequestParam Long autorId) {
        post.setAutor(usuarioServicio.obtenerUsuarioPorId(autorId).toEntity());
        return postServicio.crearPost(post);
    }

    @GetMapping
    public List<PostDTO> obtenerTodosLosPosts() {
        return postServicio.obtenerTodosLosPosts();
    }

    @GetMapping("/{id}")
    public PostDTO obtenerPostPorId(@PathVariable Long id) {
        return postServicio.obtenerPostPorId(id);
    }

    @PutMapping("/actualizar/{id}")
    public PostDTO actualizarPost(@PathVariable Long id, @RequestBody Post nuevosDatos) {
        nuevosDatos.setAutor(postServicio.obtenerPostPorId(id).getAutor().toEntity());
        return postServicio.actualizarPost(id, nuevosDatos);
    }

    @DeleteMapping("/eliminar/{id}")
    public String eliminarPost(@PathVariable Long id) {
        postServicio.eliminarPost(id);
        return "Post eliminado exitosamente";
    }



}


