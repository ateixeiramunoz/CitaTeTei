package com.eoi.CitaTe.controllers;


import com.eoi.CitaTe.apiforms.EmpresaForm;
import com.eoi.CitaTe.dto.EmpleadoDTO;
import com.eoi.CitaTe.entities.Direccion;
import com.eoi.CitaTe.entities.Empleado;
import com.eoi.CitaTe.entities.Empresa;
import com.eoi.CitaTe.entities.Usuario;
import com.eoi.CitaTe.repositories.EmpleadoRepository;
import com.eoi.CitaTe.repositories.EmpresaRepository;
import com.eoi.CitaTe.repositories.UsuarioRepository;
import com.eoi.CitaTe.services.mapper.EmpleadoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class AltaController {

    @Autowired
    UsuarioRepository usuarioRepository;
    @Autowired
    EmpresaRepository  empresaRepository;

    @Autowired
    EmpleadoRepository  empleadoRepository;

    @Autowired
    BCryptPasswordEncoder passwordEncoder;


    @Autowired
    EmpleadoMapper empleadoMapper;

    @PostMapping("/crearusuario")
    Usuario crearUsuario(Usuario usuario )
    {

      usuario.setPass(passwordEncoder.encode(usuario.getPass()));
      Usuario usuarioNuevo = usuarioRepository.save(usuario);

      return usuarioNuevo;

    }

    @PostMapping("/crearEmpresa")
    Empresa crearEmpresa(EmpresaForm empresaForm )
    {

        Empresa empresa = new Empresa();

        empresa.setDescripcionEmpresa(empresaForm.getDescripcionEmpresa());
        empresa.setCif(empresaForm.getCif());
        Direccion direccion = new Direccion();
        direccion.setCalle(empresaForm.getCalle());
        direccion.setNumero(empresaForm.getNumero());
        empresa.setDireccion(direccion);
        Empleado empleado = new Empleado();
        empleado.setNombreEmpleado("PEPE");
        empresa.getEmpleados().add(empleado);
        empresa= empresaRepository.save(empresa);

        return empresa;

    }



    @PostMapping("/crearJefeEmpresa")
    Empleado creaJefeEmpresa(EmpleadoDTO empleadoDTO)
    {
        Empleado empleado = empleadoMapper.toEntity(empleadoDTO);

        empleado.setEmpresa(empleadoDTO.getEmpresa());

        return empleadoRepository.save(empleado);
    }





}
