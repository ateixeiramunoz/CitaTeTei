package com.eoi.CitaTe.controllers;


import com.eoi.CitaTe.entities.Usuario;
import com.eoi.CitaTe.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AltaController {

    @Autowired
    UsuarioRepository usuarioRepository;


    @PostMapping("/crearUsuario")
    Usuario crearUsuario(@RequestBody Usuario usuario )
    {
      return usuarioRepository.save(usuario);
    }



}
