package com.alura.forohubapi.Dto;

import java.util.Date;
import java.util.List;

public record PostDTO (Long id, String titulo, String contenido, Date fecha, String status, String curso, UsuarioDTO autor ){
    public UsuarioDTO getAutor() {
        return null;
    }
}
