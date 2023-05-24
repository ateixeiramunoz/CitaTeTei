package com.eoi.CitaTe.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class MiSecurityConfi {

    // Creamos nuestro propio bean de la SecurityFilterChain para configurar
    // el comportamiento de spring Security
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        //Configuramos el Metodo HTTPSecurity para indicar la cadena de filtros de Autotización que vamos a seguir;
        http.authorizeHttpRequests((requests) -> requests
                .requestMatchers("/**","" ).permitAll()
                .requestMatchers("/webjars/**").permitAll()
                .anyRequest().authenticated()
        );

        //Configuramos la página personalizada de login. Además le permitimos acceso a todo el mundo.
        http.formLogin((form) -> form  .loginPage("/login").permitAll());

        // Configuramos el sistema de logout de la aplicacion como el logout por defecto de SpringSecurity
        http.logout((logout) -> logout.permitAll());

        //Devolvemos el objeto HTTPSecurity Configurado para que SpringBoot y Spring Security hagan su magia
        return http.build();
    }





    }
