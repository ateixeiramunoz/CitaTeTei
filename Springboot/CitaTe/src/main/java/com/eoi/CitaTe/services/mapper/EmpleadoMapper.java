package com.eoi.CitaTe.services.mapper;

import com.eoi.CitaTe.dto.EmpleadoDTO;
import com.eoi.CitaTe.entities.Cliente;
import com.eoi.CitaTe.entities.Empleado;
import com.eoi.CitaTe.repositories.EmpleadoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpleadoMapper {
    @Autowired
    EmpleadoRepository empleadoRepository;
    public EmpleadoDTO toDto(Cliente entidad){
        final EmpleadoDTO dto = new EmpleadoDTO();
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.map(entidad,dto);
        return dto;
    }
    //Convertir de dto a entidad
    public Empleado toEntity(EmpleadoDTO dto){
        final Empleado entidad = new Empleado();
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.map(dto,entidad);
        entidad.setEmpresa(empleadoRepository.findById(dto.getId()).get().getEmpresa());
        return entidad;
    }
}
