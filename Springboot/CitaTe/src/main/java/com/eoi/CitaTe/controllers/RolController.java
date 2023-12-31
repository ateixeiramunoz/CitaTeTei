package com.eoi.CitaTe.controllers;

import com.eoi.CitaTe.abstraccomponents.MiControladorGenerico;
import com.eoi.CitaTe.dto.DisponibilidadDTO;
import com.eoi.CitaTe.dto.RolDTO;
import com.eoi.CitaTe.entities.Disponibilidad;
import com.eoi.CitaTe.entities.Rol;
import com.eoi.CitaTe.errorcontrol.exceptions.MiEntidadNoEncontradaException;
import com.eoi.CitaTe.services.RolMapperService;
import com.eoi.CitaTe.services.ValoracionMapperService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("${url.rol}")

public class RolController extends MiControladorGenerico<Rol> {
    @Value("${url.rol}")
    private String urlBase;
    private String entityName = "roles";

    public RolController() {
        super();
    }

    @PostConstruct
    private void init() {
        super.entityName = urlBase;
        super.url = entityName + "/";
    }

    @Autowired
    RolMapperService rolMapperService;

    @Override
    @GetMapping("/all")
    public String getAll(Model model) {
        this.url = entityName + "/";
        List<RolDTO> entities = rolMapperService.buscarTodos();
        model.addAttribute("entities", entities);
        return url + "all-entities";
    }

    @Override
    @GetMapping("/create")
    public String create(Model model) {
        RolDTO entity = new RolDTO();
        model.addAttribute("entity", entity);
        return url + "entity-details";
    }


    @PostMapping(value = {"/actualizar"})
    public String update(@ModelAttribute RolDTO entity) {
        rolMapperService.CrearRol(entity);
        return "redirect:/" + url + "all";

    }

    @Override
    @GetMapping("/{id}")
    public String getById(@PathVariable Object id, Model model) throws MiEntidadNoEncontradaException {
        this.url = entityName + "/";
        try {
            Rol entity = service.getById(id);
            model.addAttribute("entity", entity);
            return url + "entity-details";
        } catch (MiEntidadNoEncontradaException ex) {
            model.addAttribute("mensaje", "Entidad no encontrada");
            model.addAttribute("error", ex.getMessage());
            return "error/error.html";
        }
    }

    @Override
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Object id) {
        service.delete(id);
        return "redirect:/" + url + "all";
    }


}
