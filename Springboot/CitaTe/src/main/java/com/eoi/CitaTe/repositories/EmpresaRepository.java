package com.eoi.CitaTe.repositories;

import com.eoi.CitaTe.entities.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {
}