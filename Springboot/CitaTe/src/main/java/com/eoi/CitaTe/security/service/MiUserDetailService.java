package com.eoi.CitaTe.security.service;

import com.eoi.CitaTe.entities.Usuario;
import com.eoi.CitaTe.repositories.UsuarioRepository;
import com.eoi.CitaTe.security.details.MiUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

public class MiUserDetailService  implements UserDetailsService {


    // Instanaciamos el repositorio creado para usuario y lo dejamos autowired para
    // que spring lo gestione
    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        // llamamos a los detaller de usuario que anteriormente hemos creado

        MiUserDetails userDetails = new MiUserDetails();

        Optional<Usuario> usuarioObtenidoDeLaBD = usuarioRepository.findByUsername(username);

        if (usuarioObtenidoDeLaBD.isPresent()){
            userDetails.setUsername(usuarioObtenidoDeLaBD.get().getEmail());
            userDetails.setPassword(usuarioObtenidoDeLaBD.get().getPass());

            // faltaria incluir si es empleado o si es  con setGrantedAuthorities(getAuthorities(usuarioObtenidoDeLaBD.get().getRoles()));

            return  userDetails;
        }

        return null;
    }
}
