package com.eoi.CitaTe.controllers;

import com.eoi.CitaTe.abstraccomponents.MiControladorGenerico;

import com.eoi.CitaTe.entities.Valoracion;
import com.eoi.CitaTe.errorcontrol.exceptions.MiEntidadNoEncontradaException;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("${url.valoracion}")
public class ValoracionController extends MiControladorGenerico<Valoracion> {

    @Value("${url.valoracion}")
    private String urlBase;
    private String entityName = "valoraciones";

    public ValoracionController() {
        super();
    }

    @PostConstruct
    private void init() {
        super.entityName = urlBase;
        super.url = entityName + "/";
    }

    @Override
    @GetMapping("/all")
    public String getAll(Model model) {
        this.url = entityName + "/";
        List<Valoracion> entities = service.listAll();
        model.addAttribute("entities", entities);
  //    model.addAttribute("nombreVista", entityName);
        return url + "all-entities"; // Nombre de la plantilla para mostrar todas las entidades
    }




    @Override
    @GetMapping("/create")
    public String create(Model model) {
        Valoracion entity = new Valoracion();
        model.addAttribute("entity", entity);
        return url + "entity-details"; // Nombre de la plantilla para mostrar los detalles de la entidad creada
    }


    @Override
    @PostMapping(value = {"", "/"})
    public String update(@ModelAttribute Valoracion entity, Model model) {
    Valoracion updatedEntity = service.update((Valoracion) entity);
    model.addAttribute("entity", updatedEntity);
    return "redirect:/" + url  + "all"; // Nombre de la plantilla para mostrar los detalles de la entidad actualizada
    }



    @Override
    @GetMapping("/{id}")
    public String getById(@PathVariable Object id, Model model) throws MiEntidadNoEncontradaException {
        this.url = entityName + "/";
        try {
            Valoracion entity = service.getById(id);
            model.addAttribute("entity", entity);
            return url + "entity-details"; // Nombre de la plantilla para mostrar los detalles de la entidad
        } catch (MiEntidadNoEncontradaException ex) {
            model.addAttribute("mensaje", "Entidad no encontrada");
            model.addAttribute("error", ex.getMessage());
            return "error/error.html"; // Nombre de la plantilla para mostrar la página de error
        }
    }


    @Override
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Object id) {
        service.delete(id);
        return "redirect:/" + url +  "all";
    }
}
