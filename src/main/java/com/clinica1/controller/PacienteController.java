package com.clinica1.controller;

import com.clinica1.entities.Odontologo;
import com.clinica1.entities.Paciente;
import com.clinica1.service.OdontologoServiceImpl;
import com.clinica1.service.PacienteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/paciente")
@CrossOrigin("*")
public class PacienteController {
    @Autowired
    private PacienteServiceImpl pacienteService ;

    public PacienteController(PacienteServiceImpl pacienteService) {
        this.pacienteService =pacienteService;
    }

    @PostMapping()
    public ResponseEntity<Paciente> registrarOdontologo(@RequestBody Paciente paciente) {
        return ResponseEntity.ok(pacienteService.registarPaciente(paciente));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Paciente> buscar(@PathVariable Long id) {
        Paciente paciente = pacienteService.buscarPorID(id).orElse(null);

        return ResponseEntity.ok(paciente);
    }

        @PutMapping()
        public ResponseEntity<Paciente> actualizar(@RequestBody Paciente paciente) {
            ResponseEntity<Paciente> response = null;

            if (paciente.getId() != null && pacienteService.buscarPorID(paciente.getId()).isPresent())
                response = ResponseEntity.ok(pacienteService.actualizar(paciente));
            else
                response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();

            return response;
        }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Long id) {
        ResponseEntity<String> response = null;

        if (pacienteService.buscarPorID(id).isPresent()) {
            pacienteService.eliminarPorId(id);
            response = ResponseEntity.status(HttpStatus.NO_CONTENT).body("Eliminado");
        } else {
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return response;
    }
    @GetMapping
    public ResponseEntity<List<Paciente>> buscarTodos(){
        return ResponseEntity.ok(pacienteService.buscarTodos());
    }



}


