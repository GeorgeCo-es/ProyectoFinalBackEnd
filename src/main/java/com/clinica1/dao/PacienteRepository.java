package com.clinica1.dao;

import com.clinica1.entities.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long> {
//    @Query("SELECT p FROM Paciente where p.nombre=?1")
//    Optional<Paciente> buscarPaciente(String nombre);
}
