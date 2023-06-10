package com.eoi.CitaTe.services;

import com.eoi.CitaTe.abstraccomponents.GenericServiceConJPA;
import com.eoi.CitaTe.dto.ClienteDTO;
import com.eoi.CitaTe.dto.UsuarioDTO;
import com.eoi.CitaTe.dto.ValoracionDTO;
import com.eoi.CitaTe.entities.Cliente;
import com.eoi.CitaTe.entities.Usuario;
import com.eoi.CitaTe.entities.Valoracion;
import com.eoi.CitaTe.repositories.ValoracionRepository;
import com.eoi.CitaTe.services.mapper.ValoracionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Valoracion1Service extends AbstractBusinessService<Valoracion, Long, ValoracionDTO, ValoracionRepository, ValoracionMapper> {

    public Valoracion1Service(ValoracionRepository repo, ValoracionMapper serviceMapper) {
        super(repo, serviceMapper);
    }

    @Autowired
    ValoracionRepository valoracionRepository;

    public void CrearValoracion(ValoracionDTO valoracionDTO){

        Valoracion valoracion = new Valoracion();


        valoracion.setId(valoracionDTO.getId());
        valoracion.setPuntuacion(valoracionDTO.getPuntuacion());
        valoracion.setComentario(valoracionDTO.getComentario());

        valoracionRepository.save(valoracion);

    }
}
