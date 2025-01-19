package com.alura.forohubapi.Controlador;

import com.alura.forohubapi.Dto.UsuarioDTO;
import com.alura.forohubapi.Entity.Usuario;
import com.alura.forohubapi.Servicio.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
public class UsuarioControlador {

    @Autowired
    private UsuarioServicio usuarioServicio;

    @PostMapping("/registrar")
    public UsuarioDTO registrarUsuario(@RequestBody UsuarioDTO usuarioDTO) {
        return usuarioServicio.registrarUsuario(usuarioDTO);
    }
    @GetMapping("/{id}") public UsuarioDTO obtenerUsuarioPorId(@PathVariable Long id) {
        return usuarioServicio.obtenerUsuarioPorId(id);}
   // @GetMapping("/{email}")
    //public Usuario obtenerUsuarioPorEmail(@PathVariable String email) {
      //  return usuarioServicio.obtenerUsuarioPorEmail(email);
    //}
}
