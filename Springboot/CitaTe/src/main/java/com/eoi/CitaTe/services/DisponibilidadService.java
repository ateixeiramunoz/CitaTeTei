package com.eoi.CitaTe.services;

import com.eoi.CitaTe.abstraccomponents.GenericServiceConJPA;
import com.eoi.CitaTe.dto.DisponibilidadDTO;
import com.eoi.CitaTe.dto.ValoracionDTO;
import com.eoi.CitaTe.entities.Disponibilidad;
import com.eoi.CitaTe.entities.Valoracion;
import com.eoi.CitaTe.repositories.DisponibilidadRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DisponibilidadService extends GenericServiceConJPA<Disponibilidad, Long> {

    @Autowired
    DisponibilidadRepository disponibilidadRepository;

}