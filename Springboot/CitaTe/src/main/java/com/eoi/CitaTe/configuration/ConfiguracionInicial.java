package com.eoi.CitaTe.configuration;

import com.eoi.CitaTe.entities.*;
import com.eoi.CitaTe.repositories.*;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.ContextRefreshedEvent;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;



@Component
public class ConfiguracionInicial implements ApplicationListener<ContextRefreshedEvent> {
    boolean configuracionRealizada = false;
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private DisponibilidadRepository disponibilidadRepository;
    @Autowired
    private EmpleadoRepository empleadoRepository;
    @Autowired
    private EmpresaRepository empresaRepository;

    @Autowired
    private FacturacionRepository facturacionRepository;

    @Autowired
    private MenuRepository menuRepository;

    @Autowired
    private MetodoPagoMensualRepository metodoPagoMensualRepository;
    @Autowired
    private PagoRepository pagoRepository;
    @Autowired
    private ReservaRepository reservaRepository;
    @Autowired
    private RolRepository rolRepository;
    @Autowired
    private ServicioRepository servicioRepository;
    @Autowired
    private ValoracionRepository valoracionRepository;

    @Autowired
    private PasswordEncoder codificadorContraseña;


        @Override
        @Profile("local")
        @Transactional
        public void onApplicationEvent(ContextRefreshedEvent event) {


            if (configuracionRealizada)
                return;

            Empresa empresa = new Empresa();

            empresa.setCif("B999999999");
            empresa.setNombreEmpresa("Ache");
            empresa.setDireccion(new Direccion("principal",5,"Madrid","Getafe",28001,"sin_defenir"));
            empresa.setDescripcionEmpresa("La mejor peluqueria");
            empresa.setContacto(new Contacto("612314123","","ayuda@gmail.com"));
            empresaRepository.save(empresa);

            Cliente cliente = new Cliente();
            cliente.setNombreCliente("Adolfo");
            cliente.setApellido1Cliente("Ramirez");
            cliente.setApellido2Cliente("Rodriguez");
            cliente.setTelefono("633159753");

            Usuario usuario = new Usuario();
            usuario.setEmail("cliente@citate.com");
            usuario.setActivo(true);
            usuario.setCliente(cliente);
            usuario.setPass(codificadorContraseña.encode("prueba"));

            usuarioRepository.save(usuario);


            Usuario usuario2 = new Usuario();

            usuario2.setEmail("empleado@citate.com");
            usuario2.setActivo(true);
            usuario2.setPass(codificadorContraseña.encode("prueba"));
            usuarioRepository.save(usuario2);

            configuracionRealizada = true;
        }




}

