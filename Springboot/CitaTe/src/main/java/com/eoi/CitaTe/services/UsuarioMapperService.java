package com.eoi.CitaTe.services;

import com.eoi.CitaTe.dto.UsuarioDTO;
import com.eoi.CitaTe.dto.ValoracionDTO;
import com.eoi.CitaTe.entities.Usuario;
import com.eoi.CitaTe.entities.Valoracion;
import com.eoi.CitaTe.repositories.UsuarioRepository;
import com.eoi.CitaTe.repositories.ValoracionRepository;
import com.eoi.CitaTe.services.mapper.UsuarioMapper;
import com.eoi.CitaTe.services.mapper.ValoracionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioMapperService extends AbstractBusinessService<Usuario, Long, UsuarioDTO, UsuarioRepository, UsuarioMapper> {

    public UsuarioMapperService(UsuarioRepository usuarioRepository, UsuarioMapper mapper) {
        super(usuarioRepository, mapper);
    }

    @Autowired
    UsuarioRepository usuarioRepository;

    public void CrearUsuario(UsuarioDTO usuarioDTO) {

        Usuario usuario = new Usuario();

        usuario.setId(usuarioDTO.getId());
        usuario.setEmail(usuarioDTO.getEmail());
        usuario.setPass(usuarioDTO.getPass());
        usuario.setActivo(usuarioDTO.isActivo());

//        usuario.setCliente(usuarioDTO.setCliente());
//        usuario.setEmpleado(usuarioDTO.getEmpleado());


        usuarioRepository.save(usuario);

    }
}
