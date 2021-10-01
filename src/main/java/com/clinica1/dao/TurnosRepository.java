package com.clinica1.dao;

import com.clinica1.entities.Domicilio;
import com.clinica1.entities.Odontologo;
import com.clinica1.entities.Turno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TurnosRepository extends JpaRepository<Turno,Long> {
//    @Query("SELECT o FROM Odontologo where o.nombre=?1")
//    Optional<Odontologo> buscarOdontologo(String nombre);
}
