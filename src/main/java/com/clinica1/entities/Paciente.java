package com.clinica1.entities;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "paciente")
@Setter @Getter
public class Paciente {
    @Id
    @SequenceGenerator(name = "paciente_sequance", sequenceName = "paciente_sequance",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="paciente_sequance")
    private Long id;
    private String nombre;
    private String apellido;
    private String dni;
    private Date fechaIngreso;



    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name="domicilios_id",referencedColumnName = "id")
    private Domicilio domicilio;


    @OneToMany(mappedBy = "paciente",fetch = FetchType.LAZY)
    private Set<Turno> turnos =new HashSet<>();
//    @ManyToMany(fetch = FetchType.EAGER,
//    cascade = CascadeType.ALL)
//    @JoinTable(name = "turno",joinColumns = {@JoinColumn(name = "paciente_id")},inverseJoinColumns = @JoinColumn(name = "odontologo_id"))
//    private Set<Odontologo> odontologo= new HashSet<>();

    private LocalDateTime registeredAt;
    public Paciente(){};

    public Paciente(Long id,String nombre, String apellido, String dni,Date fechaIngreso,Domicilio domicilio) {
        this.id=id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.fechaIngreso = fechaIngreso;
        this.domicilio = domicilio;
    }



    public Paciente(String nombre, String apellido, String dni, Date fechaIngreso, Domicilio domicilio) {

        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.fechaIngreso = fechaIngreso;
        this.domicilio = domicilio;
    }


}
