package com.eoi.CitaTe.repositories;

import com.eoi.CitaTe.entities.Empresa;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {

    Page<Empresa> findByDireccionProvinciaIgnoreCase(String provincia, Pageable pageable);
}