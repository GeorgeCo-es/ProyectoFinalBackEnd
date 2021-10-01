package com.clinica1.controller;

import com.clinica1.dto.OdontologoDTO;
import com.clinica1.entities.Odontologo;
import com.clinica1.service.OdontologoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


    @RestController
    @RequestMapping("/odontologos")
    @CrossOrigin("*")
    public class OdontologoController {
        @Autowired
        private OdontologoServiceImpl odontologoService ;

        public OdontologoController(OdontologoServiceImpl odontologoService) {
            this.odontologoService = odontologoService;
        }

        @PostMapping()
        public ResponseEntity<?> registrarOdontologo(@RequestBody Odontologo odontologo) {
            return ResponseEntity.ok(odontologoService.registrarOdontologo(odontologo));
        }

        @GetMapping("/{id}")
        public ResponseEntity<Odontologo> buscar(@PathVariable Long id) {
            Odontologo odontologo = odontologoService.buscarPorID(id).orElse(null);

            return ResponseEntity.ok(odontologo);
        }

        @PutMapping()
        public ResponseEntity<Odontologo> actualizar(@RequestBody Odontologo odontologo) {
            ResponseEntity<Odontologo> response = null;

            if (odontologo.getId() != null && odontologoService.buscarPorID(odontologo.getId()).isPresent())
                response = ResponseEntity.ok(odontologoService.actualizar(odontologo));
            else
                response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();

            return response;
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<String> eliminar(@PathVariable Long id) {
            ResponseEntity<String> response = null;

            if (odontologoService.buscarPorID(id).isPresent()) {
                odontologoService.eliminarPorId(id);
                response = ResponseEntity.status(HttpStatus.NO_CONTENT).body("Eliminado");
            } else {
                response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }

            return response;
        }
        @GetMapping
        public ResponseEntity<List<Odontologo>> buscarTodos(){
            return ResponseEntity.ok(odontologoService.buscarTodos());
        }



    }


