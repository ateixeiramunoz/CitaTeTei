package com.eoi.CitaTe.controllers;

import com.eoi.CitaTe.abstraccomponents.MiControladorGenerico;
import com.eoi.CitaTe.dto.ClienteDTO;
import com.eoi.CitaTe.dto.EmpleadoDTO;
import com.eoi.CitaTe.dto.EmpresaDTO;
import com.eoi.CitaTe.dto.UsuarioDTO;
import com.eoi.CitaTe.entities.Empresa;
import com.eoi.CitaTe.repositories.EmpresaRepository;
import com.eoi.CitaTe.repositories.UsuarioRepository;
import com.eoi.CitaTe.services.EmpleadoService;
import com.eoi.CitaTe.services.EmpresaService;
import com.eoi.CitaTe.services.UsuarioService;
import jakarta.annotation.PostConstruct;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("${url.empresa}")
@RequiredArgsConstructor
public class EmpresaController extends MiControladorGenerico<Empresa> {

    @Value("${url.empresa}")
    private String urlBase;

    private String url = "empresas";
    private String entityName = "empresa";

    private final EmpresaRepository empresaRepository;

    @PostConstruct
    private void init() {
        super.entityName = entityName;
        super.url = url;
    }


    //Enviar los datos al registro de empresa
    @Override
    @GetMapping("/createEmpresa")
    public String create(Model model) {
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        EmpresaDTO empresaDTO = new EmpresaDTO();
        EmpleadoDTO empleadoDTO = new EmpleadoDTO();

        model.addAttribute("usuarioDTO", usuarioDTO);
        model.addAttribute("empresaDTO", empresaDTO);
        model.addAttribute("empleadoDTO", empleadoDTO);
//        model.addAttribute("url", url);
        model.addAttribute("entityName", entityName);

        return "registroEmpresa/registroEmpresa2"; // Nombre de la plantilla para mostrar todas las entidades
    }

    private final UsuarioService usuarioService;


    @PostMapping(value = {"/altaEmpresa"})
    public String update(@ModelAttribute UsuarioDTO usuarioDTO,
                         @ModelAttribute EmpresaDTO empresaDTO,
                         @ModelAttribute EmpleadoDTO empleadoDTO) {
        usuarioService.CrearEmpresa(usuarioDTO, empresaDTO, empleadoDTO);


        return "registroEmpresa/registroEmpresa12";
    }
}
