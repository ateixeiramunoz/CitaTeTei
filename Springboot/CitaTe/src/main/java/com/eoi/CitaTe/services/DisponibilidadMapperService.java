package com.eoi.CitaTe.services;

import com.eoi.CitaTe.dto.DisponibilidadDTO;
import com.eoi.CitaTe.entities.Disponibilidad;
import com.eoi.CitaTe.repositories.DisponibilidadRepository;
import com.eoi.CitaTe.services.mapper.DisponibilidadMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DisponibilidadMapperService extends AbstractBusinessService<Disponibilidad, Long, DisponibilidadDTO, DisponibilidadRepository, DisponibilidadMapper>{

    public DisponibilidadMapperService(DisponibilidadRepository disponibilidadRepository, DisponibilidadMapper mapper) {
        super(disponibilidadRepository, mapper);
    }

    @Autowired
    DisponibilidadRepository disponibilidadRepository;

    public void CrearDisponibilidad(DisponibilidadDTO disponibilidadDTO){

        Disponibilidad disponibilidad = new Disponibilidad();

        disponibilidad.setId(disponibilidadDTO.getId());
        disponibilidad.setFecha(disponibilidadDTO.getFecha());
        disponibilidad.setHora_inicio_mañana(disponibilidadDTO.getHora_inicio_mañana());
        disponibilidad.setHora_fin_mañana(disponibilidadDTO.getHora_fin_mañana());
        disponibilidad.setHora_inicio_tarde(disponibilidadDTO.getHora_inicio_tarde());
        disponibilidad.setHora_fin_tarde(disponibilidadDTO.getHora_fin_tarde());

        disponibilidadRepository.save(disponibilidad);

    }
}
