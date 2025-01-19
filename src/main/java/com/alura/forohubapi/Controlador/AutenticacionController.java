package com.alura.forohubapi.Controlador;


import com.alura.forohubapi.Dto.DatosAutenticacionUsuario;
import jakarta.validation.Valid;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AutenticacionController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping
    public ResponseEntity realizarLogin(@RequestBody @Valid DatosAutenticacionUsuario datosAutenticacionUsuario) {
        var token = new UsernamePasswordAuthenticationToken(datosAutenticacionUsuario.login(),datosAutenticacionUsuario.clave());
        var authentication = authenticationManager.authenticate(token);
       // Authentication token=new UsernamePasswordAuthenticationToken(datosAutenticacionUsuario.login(),
         //       datosAutenticacionUsuario.clave());
        //authenticationManager.authenticate(token);
        return ResponseEntity.ok().build();
    }
}
