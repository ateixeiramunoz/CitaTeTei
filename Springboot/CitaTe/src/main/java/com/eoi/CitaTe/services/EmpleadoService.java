package com.eoi.CitaTe.services;

import com.eoi.CitaTe.abstraccomponents.GenericServiceConJPA;
import com.eoi.CitaTe.dto.EmpleadoDTO;
import com.eoi.CitaTe.dto.UsuarioDTO;
import com.eoi.CitaTe.entities.Empleado;
import com.eoi.CitaTe.entities.Usuario;
import com.eoi.CitaTe.repositories.EmpleadoRepository;
import com.eoi.CitaTe.repositories.UsuarioRepository;
import com.eoi.CitaTe.services.mapper.EmpleadoMapper;
import com.eoi.CitaTe.services.mapper.UsuarioMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpleadoService extends GenericServiceConJPA<Empleado, Long> {

    @Autowired
    EmpleadoRepository empleadoRepository;
    @Autowired
    private EmpleadoMapper empleadoMapper;


    public Empleado CrearEmpleado(EmpleadoDTO empleadoDTO ){
        Empleado empleado = empleadoMapper.toEntity(empleadoDTO);
        return empleadoRepository.save(empleado);
    }
}
