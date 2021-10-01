package com.clinica1.dao;

import com.clinica1.entities.Odontologo;
import com.clinica1.entities.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface OdontologoRepository extends JpaRepository<Odontologo,Long> {
//    @Query("SELECT o Odontologo FROM Odontologo where o.nombre=?1")
//    Optional<Odontologo> buscarPorNombre(String nombre);

//    @Modifying
//    @Query("insert into Odontologo (nombre,apellido,matricula) select :nombre,:apellido,:matricula from Odontologo")
//    public int insertarDatos(@Param("nombre")String nombre, @Param("apellido")String apellido, @Param("matricula")Integer matricula);
//
}
