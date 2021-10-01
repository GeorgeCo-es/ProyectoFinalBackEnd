package com.clinica1.dao;

import com.clinica1.entities.Domicilio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DomicilioRespository extends JpaRepository<Domicilio,Long> {
}
