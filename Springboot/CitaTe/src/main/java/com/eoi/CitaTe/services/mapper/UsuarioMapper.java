package com.eoi.CitaTe.services.mapper;

import com.eoi.CitaTe.dto.ClienteDTO;
import com.eoi.CitaTe.dto.EmpleadoDTO;
import com.eoi.CitaTe.dto.UsuarioDTO;
import com.eoi.CitaTe.dto.UsuarioDTO1;
import com.eoi.CitaTe.entities.Cliente;
import com.eoi.CitaTe.entities.Usuario;
import com.eoi.CitaTe.repositories.ClienteRepository;
import com.eoi.CitaTe.repositories.EmpleadoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioMapper {
    @Autowired
    private PasswordEncoder codificadorContraseñas;

    ClienteMapper clienteMapper;
    EmpleadoMapper empleadoMapper;

    @Autowired
    ClienteRepository clienteRepository;
    @Autowired
    EmpleadoRepository empleadoRepository;

    //Ofrece los método para copiar datos desde dtos a entidades para el guardado
    public Usuario toEntity(UsuarioDTO1 usrdto){
        final Usuario entidad = new Usuario();
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.map(entidad,usrdto);

            //Contraseña
          //  entidad.setPass(codificadorContraseñas.encode(usrdto.getPass()));
            //Pasamos a la parte de clientes
            //Mapeamos del dto a ala entidad
            Cliente clienteaguardar = clienteMapper.toEntity(usrdto.getClienteDTO());
            //Guardamos la entidad cliente
            Cliente clienteguardado = clienteRepository.save(clienteaguardar);
            //Añadimos la entidad cliente al usuario
            entidad.setCliente(clienteguardado);

//            //Pasamos a la parte de empresas
//            //Mapeamos del dto a a la entidad
//            Empleado empleadoaguardar = empleadoMapper.toEntity(usrdto.getEmpleadoDTO());
//            //Guardamos la entidad cliente
//            Empleado empleadoguardado = empleadoRepository.save(empleadoaguardar);
//            //Añadimos la entidad cliente al usuario
//            entidad.setEmpleado(empleadoguardado);

        return entidad;
    }
    public UsuarioDTO toDtoUsuario(Usuario entidad){
        final UsuarioDTO dto = new UsuarioDTO();
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.map(dto,entidad);
        return dto;
    }
    public ClienteDTO toDtoCliente(Usuario entidad){
        final ClienteDTO dto = new ClienteDTO();
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.map(dto,entidad.getCliente());
        return dto;
    }
    public EmpleadoDTO toDtoEmpleado(Usuario entidad){
        final EmpleadoDTO dto = new EmpleadoDTO();
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.map(dto,entidad.getEmpleado());
        return dto;
    }

}
