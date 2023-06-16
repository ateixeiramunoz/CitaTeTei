package com.eoi.CitaTe.services;

import com.eoi.CitaTe.abstraccomponents.GenericServiceConJPA;
import com.eoi.CitaTe.dto.DisponibilidadDTO;
import com.eoi.CitaTe.dto.ValoracionDTO;
import com.eoi.CitaTe.entities.Disponibilidad;
import com.eoi.CitaTe.entities.Valoracion;
import com.eoi.CitaTe.repositories.DisponibilidadRepository;
import com.eoi.CitaTe.services.mapper.DisponibilidadMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DisponibilidadService extends GenericServiceConJPA<Disponibilidad, Long> {

    @Autowired
    DisponibilidadRepository disponibilidadRepository;

    @Autowired
    DisponibilidadMapper disponibilidadMapper;

    public Disponibilidad CrearDisponibilidad(DisponibilidadDTO disponibilidadDTO){
        Disponibilidad disponibilidad = disponibilidadMapper.toEntity(disponibilidadDTO);
        return disponibilidadRepository.save(disponibilidad);
    }

}