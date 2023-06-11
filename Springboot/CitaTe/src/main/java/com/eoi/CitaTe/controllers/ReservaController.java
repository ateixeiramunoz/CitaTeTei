package com.eoi.CitaTe.controllers;

import com.eoi.CitaTe.abstraccomponents.MiControladorGenerico;

import com.eoi.CitaTe.dto.DisponibilidadDTO;
import com.eoi.CitaTe.dto.ReservaDTO;
import com.eoi.CitaTe.entities.Disponibilidad;
import com.eoi.CitaTe.entities.Reserva;
import com.eoi.CitaTe.errorcontrol.exceptions.MiEntidadNoEncontradaException;
import com.eoi.CitaTe.repositories.ReservaRepository;
import com.eoi.CitaTe.services.ReservaMapperService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("${url.reserva}")
public class ReservaController extends MiControladorGenerico<Reserva> {
    @Value("${url.reserva}")
    private String urlBase;
    private String entityName = "reservas";

    public ReservaController() {
        super();
    }

    @PostConstruct
    private void init() {
        super.entityName = entityName;
        super.url = url;
    }

    @Autowired
    ReservaMapperService reservaMapperService;

    @Override
    @GetMapping("/all")
    public String getAll(Model model) {
        this.url = entityName + "/";
        List<ReservaDTO> entities = reservaMapperService.buscarTodos();
        model.addAttribute("entities", entities);
        return url + "all-entities";
    }

    @Override
    @GetMapping("/create")
    public String create(Model model) {
        ReservaDTO entity = new ReservaDTO();
        model.addAttribute("entity", entity);
        return url + "entity-details";
    }


    @PostMapping(value = {"/actualizar"})
    public String update(@ModelAttribute ReservaDTO entity) {
        reservaMapperService.CrearReserva(entity);
        return "redirect:/" + url + "all";

    }

    @Override
    @GetMapping("/{id}")
    public String getById(@PathVariable Object id, Model model) throws MiEntidadNoEncontradaException {
        this.url = entityName + "/";
        try {
            Reserva entity = service.getById(id);
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
