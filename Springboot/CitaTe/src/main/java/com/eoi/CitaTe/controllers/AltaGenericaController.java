package com.eoi.CitaTe.controllers;

import com.eoi.CitaTe.dto.AltaGenericaDto;
import com.eoi.CitaTe.dto.CatalogoDeServicioDTO;
import com.eoi.CitaTe.dto.DisponibilidadDTO;
import com.eoi.CitaTe.dto.ServicioDTO;
import com.eoi.CitaTe.entities.*;
import com.eoi.CitaTe.repositories.UsuarioRepository;
import com.eoi.CitaTe.services.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("${url.usuario}")
@RequiredArgsConstructor
public class AltaGenericaController {


    private final UsuarioRepository usuarioRepository;
    private final UsuarioService usuarioService;
    private final UsuarioMapperService usuarioMapperService;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @Autowired
    private EmailService emailService;

    @Autowired
    EmpresaService empresaService;

    @Autowired
    DisponibilidadService disponibilidadService;

    @Autowired
    ServicioService servicioService;

    @Autowired
    ClienteService clienteService;

    @Autowired
    EmpleadoService empleadoService;

    @Autowired
    CatalogoDeServicioService catalogoDeServicioService;


    @GetMapping("/create/nuevaalta")
    public String createEmp(Model model) {

        AltaGenericaDto altaGenericaDto = new AltaGenericaDto();

//        altaGenericaDto.setEmpresa(empresaService.getById(1));

        List<Disponibilidad> disponibilidadList = disponibilidadService.listAll();
        List<CatalogoDeServicio> catalogoDeServicioList = catalogoDeServicioService.listAll();
        List<Servicio> servicioList = servicioService.listAll();

        model.addAttribute("datos",altaGenericaDto);

        model.addAttribute("disponibilidadList" ,disponibilidadList );
        model.addAttribute("catalogoDeServicioList" ,catalogoDeServicioList );
        model.addAttribute("servicioList" ,servicioList );


        return "registroEmpresa/nuevaalta";
    }


    @PostMapping(value = {"/create"})
    public String update(@ModelAttribute AltaGenericaDto altaGenericaDto,
                         @ModelAttribute CatalogoDeServicioDTO catalogoDeServicioDTO,
                         @ModelAttribute DisponibilidadDTO disponibilidadDTO,
                         @ModelAttribute ServicioDTO servicioDTO) {

        //Buscamos el tipo de alta

        if (altaGenericaDto.getTipoalta().equals("cliente")){

            //si el tipo de alta es cliente guardo el cliente y el usuario respectivamente
            //guardo el cliente
            Cliente clienteguardado = clienteService.CrearCliente(altaGenericaDto.getCliente());
            //guardo el usuario
            altaGenericaDto.getUsuario().setCliente(clienteguardado);

        } else if (altaGenericaDto.getTipoalta().equals("empleado")) {

            //si el tipo de alta es empleado guardaré empleado y usuario
            //guardo empleado
            Empleado empleadoguardado = empleadoService.CrearEmpleado(altaGenericaDto.getEmpleado());
            //guardo usuario
            altaGenericaDto.getUsuario().setEmpleado(empleadoguardado);


        } else if (altaGenericaDto.getTipoalta().equals("empresa")){

            //si el tipo de alta es empresa, guardo: empresa, empleado y usuario
            //Tambien disponibilidad, catalogo de servicios etc

            //guardamos el catalogo de servicios
            CatalogoDeServicio catalogoDeServicio = catalogoDeServicioService.CrearCatalogoDeServicio(catalogoDeServicioDTO);

            //guardamos disponibilidad
            Disponibilidad disponibilidad = disponibilidadService.CrearDisponibilidad(disponibilidadDTO);

            //guardo empresa
            Empresa empresaguardada = empresaService.CrearEmpresa(altaGenericaDto.getEmpresa());
            //guardo empleado
            Empleado empleadoguardado = empleadoService.CrearEmpleado(altaGenericaDto.getEmpleado());
            //guardo usuario
            altaGenericaDto.getUsuario().setEmpleado(empleadoguardado);

        } else {
            System.out.println("Suave suavesito ya queda poquito");
        }

        Usuario usuarioguardado = usuarioService.CrearUsuario(altaGenericaDto.getUsuario());

        return "registroEmpresa/registroEmpresa12";

    }

}
