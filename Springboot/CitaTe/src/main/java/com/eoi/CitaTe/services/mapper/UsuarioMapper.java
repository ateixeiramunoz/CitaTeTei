package com.eoi.CitaTe.services.mapper;

import com.eoi.CitaTe.dto.*;
import com.eoi.CitaTe.entities.Cliente;
import com.eoi.CitaTe.entities.Empleado;
import com.eoi.CitaTe.entities.Usuario;
import com.eoi.CitaTe.repositories.ClienteRepository;
import com.eoi.CitaTe.repositories.EmpleadoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioMapper extends AbstractServiceMapper<Usuario, UsuarioDTO> {

    @Autowired
    private PasswordEncoder codificadorContraseñas;
    @Autowired
    ClienteMapper clienteMapper;
    @Autowired
    EmpleadoMapper empleadoMapper;

    @Autowired
    ClienteRepository clienteRepository;
    @Autowired
    EmpleadoRepository empleadoRepository;


    //Convertir de entidad a dto
    @Override
    public UsuarioDTO toDto(Usuario entidad){
        final UsuarioDTO dto = new UsuarioDTO();
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.map(entidad,dto);
        dto.setEmail(entidad.getEmail());
        return dto;
    }

    public Usuario toEntity(UsuarioDTO dto){
        final Usuario entidad = new Usuario();
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.map(dto, entidad);



//        String strCliente = "cliente";
//        System.out.println(dto.getTipoAlta().equals(strCliente));
//        if (dto.getTipoAlta().equals(strCliente)){
//            //Contraseña
//            //entidad.setPass(codificadorContraseñas.encode(usrdto.getPass()));
//            entidad.setPass(dto.getPass());
//            //Pasamos a la parte de clientes
//            //Mapeamos del dto a ala entidad
//            Cliente clienteaguardar = clienteMapper.toEntity(dto.getClienteDTO());
//
//            //Guardamos la entidad cliente
//            Cliente clienteguardado = clienteRepository.save(clienteaguardar);
//            //Añadimos la entidad cliente al usuario
//            entidad.setCliente(clienteguardado);
//        } else {
//            //Pasamos a la parte de empresas
//            //Mapeamos del dto a a la entidad
//            Empleado empleadoaguardar = empleadoMapper.toEntity(dto.getEmpleadoDTO());
//            //Para el id de empresa leer y añadir el elemento
//            //            usrdto.getEmpleadoDTONuevo().getEmpresa_id()
//            //  Busco la empresa completa
//            //empleadoaguardar.setEmpresa(...);
//
//
//            //Guardamos la entidad cliente
//            Empleado empleadoguardado = empleadoRepository.save(empleadoaguardar);
//            //Para el id de empresa leer y añadir el elemento
//            //            usrdto.getEmpleadoDTONuevo().getEmpresa_id()
//
//
//            //Añadimos la entidad cliente al usuario
//            entidad.setEmpleado(empleadoguardado);
//        }
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
    public Usuario toEntityPsw(UsuarioDTOPsw dto){
        final Usuario entidad = new Usuario();
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.map(dto,entidad);
        return entidad;
    }

    public UsuarioMapper() {
    }
}