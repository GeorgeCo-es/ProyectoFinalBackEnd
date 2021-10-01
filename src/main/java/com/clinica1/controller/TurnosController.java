package com.clinica1.controller;


import com.clinica1.entities.Paciente;
import com.clinica1.entities.Turno;
import com.clinica1.service.OdontologoServiceImpl;
import com.clinica1.service.PacienteServiceImpl;
import com.clinica1.service.TurnoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/turnos")
public class TurnosController {
    @Autowired
    private final PacienteServiceImpl pacienteService ;
    @Autowired
    private final OdontologoServiceImpl odontologoService ;
    @Autowired
    private final TurnoServiceImpl turnoService ;

    public TurnosController(PacienteServiceImpl pacienteService, OdontologoServiceImpl odontologoService, TurnoServiceImpl turnoService) {
        this.pacienteService = pacienteService;
        this.odontologoService = odontologoService;
        this.turnoService = turnoService;
    }

//    ToDo Revisar como insertar un turno que esta asociado


    @PostMapping
    public ResponseEntity<Turno> registrarTurno(@RequestBody Turno turno) {
        ResponseEntity<Turno> response;
        if (pacienteService.buscarPorID(turno.getPaciente().getId()).isPresent() && odontologoService.buscarPorID(turno.getOdontologo().getId()).isPresent())
            response = ResponseEntity.ok(turnoService.registrarTurno(turno));

        else
            response = ResponseEntity.status(HttpStatus.BAD_REQUEST).build();

        return response;


    }

    @GetMapping
    public ResponseEntity<List<Turno>> listar() {
        return ResponseEntity.ok(turnoService.buscarTodos());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Long id) {
        ResponseEntity<String> response;
        if (turnoService.buscarPorID(id).isPresent()) { // Esta validacion no esta en el enunciado del ejericio, pero se las dejo para que la tengan.
            turnoService.eliminarPorId(id);
            response = ResponseEntity.status(HttpStatus.NO_CONTENT).body("Eliminado");
        } else {
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return response;
    }

    @PutMapping
    public ResponseEntity<Turno> actualizarTurno(@RequestBody Turno turno) {
        return ResponseEntity.ok(turnoService.actualizar(turno));

    }


}
