package com.eoi.CitaTe.services;

import com.eoi.CitaTe.abstraccomponents.GenericServiceConJPA;
import com.eoi.CitaTe.dto.CatalogoDeServicioDTO;
import com.eoi.CitaTe.dto.EmpresaDTO;
import com.eoi.CitaTe.entities.CatalogoDeServicio;
import com.eoi.CitaTe.entities.Empresa;
import com.eoi.CitaTe.repositories.CatalogoDeServicioRepository;
import com.eoi.CitaTe.repositories.EmpresaRepository;
import com.eoi.CitaTe.services.mapper.CatalogoDeServiciosMapper;
import com.eoi.CitaTe.services.mapper.EmpresaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CatalogoDeServicioService extends GenericServiceConJPA<CatalogoDeServicio, Long> {

    @Autowired
    private CatalogoDeServicioRepository catalogoDeServicioRepository;

    @Autowired
    private CatalogoDeServiciosMapper catalogoDeServiciosMapper;

    public CatalogoDeServicio CrearCatalogoDeServicio(CatalogoDeServicioDTO catalogoDeServicioDTO){
        CatalogoDeServicio catalogoDeServicio = catalogoDeServiciosMapper.toEntity(catalogoDeServicioDTO);
        return catalogoDeServicioRepository.save(catalogoDeServicio);
    }
}
