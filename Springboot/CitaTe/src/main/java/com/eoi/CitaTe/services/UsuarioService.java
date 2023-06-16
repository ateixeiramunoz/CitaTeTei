package com.eoi.CitaTe.services;

import com.eoi.CitaTe.abstraccomponents.GenericServiceConJPA;
import com.eoi.CitaTe.dto.*;
import com.eoi.CitaTe.entities.*;
import com.eoi.CitaTe.repositories.ClienteRepository;
import com.eoi.CitaTe.repositories.EmpleadoRepository;
import com.eoi.CitaTe.repositories.EmpresaRepository;
import com.eoi.CitaTe.repositories.UsuarioRepository;
import com.eoi.CitaTe.services.mapper.UsuarioMapper;
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

    @Autowired
    EmpleadoRepository empleadoRepository;

    @Autowired
    EmpresaRepository empresaRepository;
    @Autowired
    private UsuarioMapper usuarioMapper;


    @Autowired
    private PasswordEncoder codificadorContraseñas;
    public Usuario CrearUsuario(UsuarioDTO usuarioDTO ){
        Usuario usuario = usuarioMapper.toEntity(usuarioDTO);
        return usuarioRepository.save(usuario);
    }

    public void CrearEmpresa(UsuarioDTO usuarioDTO, EmpresaDTO empresaDTO, EmpleadoDTO empleadoDTO, DireccionDTO direccionDTO){

        Cliente cliente = new Cliente();
        Empresa empresa = new Empresa();
        Empleado empleado = new Empleado();
        Usuario usuario = new Usuario();
        Direccion direccion = new Direccion();


        direccion.setProvincia(direccionDTO.getProvincia());
        direccion.setCodigoPostal(direccionDTO.getCodigoPostal());
        direccion.setNumero(direccionDTO.getNumero());
        direccion.setCiudad(direccionDTO.getCiudad());
        direccion.setCalle(direccionDTO.getCalle());



        empresa.setDireccion(direccion);

        empresa.setDescripcionEmpresa(empresaDTO.getDescripcionEmpresa());
        empresa.setNombreEmpresa(empresaDTO.getNombreEmpresa());
        empresa.setCif(empresaDTO.getCif());
        empresa.setLogoEmpresa(empresaDTO.getLogoEmpresa());
        empresa.setTipoNegocio(empresaDTO.getTipoNegocio());

//      empresa.setContacto(empresaDTO.getContacto());

        empresaRepository.save(empresa);

        empleado.setNombreEmpleado(empleadoDTO.getNombreEmpleado());
        empleado.setApellido1Empleado(empleadoDTO.getApellido1Empleado());
        empleado.setApellido2Empleado(empleadoDTO.getApellido2Empleado());

        empleado.setEmpresa(empresa);

        empleadoRepository.save(empleado);


        usuario.setEmail(usuarioDTO.getEmail());
        usuario.setPass(codificadorContraseñas.encode(usuarioDTO.getPass()));
        usuario.setActivo(true);

        usuario.setEmpleado(empleado);
        //usuario.setRol(jefe)

        // Configurar mas adelante rol de jefe para este usuario.

        usuarioRepository.save(usuario);

        //  private Set<Empleado> empleados = new HashSet<>();
        //  private CatalogoDeServicio catalogoDeServicio;

        //private Disponibilidad disponibilidad;
        //private Set<Servicio> servicios = new HashSet<>();

    }




}
