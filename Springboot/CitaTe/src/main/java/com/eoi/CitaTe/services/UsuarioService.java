package com.eoi.CitaTe.services;

import com.eoi.CitaTe.abstraccomponents.GenericServiceConJPA;
import com.eoi.CitaTe.dto.ClienteDTO;
import com.eoi.CitaTe.dto.UsuarioDTO;
import com.eoi.CitaTe.entities.Cliente;
import com.eoi.CitaTe.entities.Usuario;
import com.eoi.CitaTe.repositories.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class UsuarioService extends GenericServiceConJPA<Usuario, Long> {

    @Autowired
    UsuarioRepository usuarioRepository;

    Usuario usuario = new Usuario();
    Cliente cliente = new Cliente();
    Empresa empresa = new Empresa();
    Empleado empleado = new Empleado();



    @Autowired
    private PasswordEncoder codificadorContraseñas;
    @Autowired
    private EmpleadoRepository empleadoRepository;
    @Autowired
    private EmpresaRepository empresaRepository;

    public void CrearCliente(UsuarioDTO usuarioDTO, ClienteDTO clienteDTO){

        usuario.setEmail(usuarioDTO.getEmail());
        usuario.setPass(codificadorContraseñas.encode(usuarioDTO.getPass()));
        usuario.setActivo(true);

        cliente.setNombreCliente(clienteDTO.getNombreCliente());
        cliente.setApellido1Cliente(clienteDTO.getApellido1Cliente());
        cliente.setApellido2Cliente(clienteDTO.getApellido2Cliente());
        cliente.setTelefono(clienteDTO.getTelefono());

        usuario.setCliente(cliente);


        usuarioRepository.save(usuario);
    }
}
