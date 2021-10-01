package com.clinica1.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="odontologo")
@Getter @Setter
public class Odontologo {
    @Id
    @SequenceGenerator(name = "odontologo_sequance", sequenceName = "odontologo_sequance",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="odontologo_sequance")
    private Long id;
    private String nombre;
    private String apellido;
    private Integer matricula;

    @OneToMany(mappedBy = "odontologo", fetch = FetchType.LAZY)
    private Set<Turno> turnos = new HashSet<>();

    public Odontologo(){};

    public Odontologo(String nombre, String apellido, Integer matricula) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.matricula = matricula;
    }


}
