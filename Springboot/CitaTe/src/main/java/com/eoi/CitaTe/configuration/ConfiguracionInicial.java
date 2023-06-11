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
    private CatalogoDeServicioRepository catalogoDeServicioRepository;
    @Autowired
    private PasswordEncoder codificadorContraseña;


        @Override
        @Profile("local")
        @Transactional
        public void onApplicationEvent(ContextRefreshedEvent event) {


            if (configuracionRealizada)
                return;

            // Empresas///////////////////////////////////////////////////

            Empresa empresa = new Empresa();
            Empresa empresa2 = new Empresa();
            Empresa empresa3 = new Empresa();

            empresa.setCif("B999999999");
            empresa.setNombreEmpresa("Ache");
            empresa.setDireccion(new Direccion("principal",5,"Madrid","Getafe",28001));
            empresa.setDescripcionEmpresa("La mejor peluqueria");
//          empresa.setContacto(new Contacto("612314123","","ayuda@gmail.com"));
            empresaRepository.save(empresa);

            empresa2.setCif("B999999998");
            empresa2.setNombreEmpresa("Imnova");
            empresa2.setDireccion(new Direccion("prudencio",20,"Almeria","Almeria",04010));
            empresa2.setDescripcionEmpresa("La mejor barberia");
//          empresa2.setContacto(new Contacto("612314123","","ayuda@gmail.com"));
            empresaRepository.save(empresa2);

            // Bucle para dar de alta varias empresas

            for (int i = 0; i <30 ; i++) {

                empresa3 = new Empresa();
                empresa3.setCif("B999999" + i + "98");
                empresa3.setNombreEmpresa("Imnova" + i);
                empresa3.setDireccion(new Direccion("prudencio",i,"Almeria","Almeria",04010));
                empresa3.setDescripcionEmpresa("La mejor barberia" + i);
                empresaRepository.save(empresa3);

            }
            // Empresas ///////////////////////////////////////////////////

            // Empleado ///////////////////////////////////////////////////

            Empleado empleado = new Empleado();

            empleado.setNombreEmpleado("Antonio");
            empleado.setApellido1Empleado("Martinez");
            empleado.setApellido2Empleado("Sanchez");
            empleado.setEmpresa(empresa);
            empleadoRepository.save(empleado);


            // Empleado ///////////////////////////////////////////////////


            //// Clientes///////////////////////////////////////////////////

            Cliente cliente = new Cliente();
            cliente.setNombreCliente("Adolfo");
            cliente.setApellido1Cliente("Ramirez");
            cliente.setApellido2Cliente("Rodriguez");
            cliente.setTelefono("633159753");

            Cliente cliente2 = new Cliente();
            cliente.setNombreCliente("Pepe");
            cliente.setApellido1Cliente("Molina");
            cliente.setApellido2Cliente("Rodriguez");
            cliente.setTelefono("631415925");
            //// clientes///////////////////////////////////////////////////

            /// valoraciones///////////////////////////////////////////////

//            private String comentario;
//
//            private boolean activo;
//
//            private int puntuacion;
//
//            private Reserva reserva;

            Valoracion valoracion = new Valoracion();
            valoracion.setComentario("Mu chala la peluqueria");
            valoracion.setPuntuacion(5);

            Valoracion valoracion2 = new Valoracion();
            valoracion2.setComentario("Mu caro saecio");
            valoracion2.setPuntuacion(1);

            valoracionRepository.save(valoracion);
            valoracionRepository.save(valoracion2);


            CatalogoDeServicio catalogoDeServicio = new CatalogoDeServicio();
            catalogoDeServicio.setNombre("Antonio");
            catalogoDeServicio.setDescripcion("viendo peliculas");
            catalogoDeServicio.setPrecio("gratis");


            CatalogoDeServicio catalogoDeServicio2 = new CatalogoDeServicio();
            catalogoDeServicio2.setNombre("Bertin Osborne");
            catalogoDeServicio2.setDescripcion("en los toros");
            catalogoDeServicio2.setPrecio("sincuenta eruo");

            catalogoDeServicioRepository.save(catalogoDeServicio);
            catalogoDeServicioRepository.save(catalogoDeServicio2);

            /// valoraciones///////////////////////////////////////////////

            /// DISPONIBILIDADES///////////////////////////////////////////////





            /// DISPONIBILIDADES///////////////////////////////////////////////




            //// Usuarios ////////////////////////////////////////////////

            Usuario usuario = new Usuario();
            usuario.setEmail("cliente@citate.com");
            usuario.setActivo(true);
            usuario.setCliente(cliente);
            usuario.setPass(codificadorContraseña.encode("prueba"));

            usuarioRepository.save(usuario);
            Usuario usuario2 = new Usuario();

            usuario2.setEmail("empleado@citate.com");
            usuario2.setActivo(true);
            usuario2.setEmpleado(empleado);
            usuario2.setPass(codificadorContraseña.encode("prueba"));
            usuarioRepository.save(usuario2);

            // Creamos un bucle para añadir un par de usuarios mas y poder comprobar paginacion

            for (int i = 0; i <30 ; i++) {

                usuario2 = new Usuario();

                usuario2.setEmail("empleado" + i + "@citate.com");
                usuario2.setActivo(true);
                usuario2.setPass(codificadorContraseña.encode("prueba"));
                usuarioRepository.save(usuario2);

            }



            configuracionRealizada = true;
        }
}

