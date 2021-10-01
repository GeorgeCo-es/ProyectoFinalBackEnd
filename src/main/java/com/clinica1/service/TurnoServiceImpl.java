package com.clinica1.service;

import com.clinica1.dao.PacienteRepository;
import com.clinica1.dao.TurnosRepository;
import com.clinica1.entities.Paciente;
import com.clinica1.entities.Turno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TurnoServiceImpl {
    private TurnosRepository turnoRepository;


    @Autowired
    public TurnoServiceImpl(TurnosRepository turnoRepository) {
        this.turnoRepository = turnoRepository;
    }


    public Optional<Turno> buscarPorID(Long id){
        return turnoRepository.findById(id);
    }

    public List<Turno> buscarTodos(){
        return turnoRepository.findAll();
    }
    public Turno registrarTurno(Turno turno){
        if(turno!=null){
            return turnoRepository.save(turno);
        }
        return new Turno();
    }
    public Turno actualizar(Turno turno){
        return turnoRepository.save(turno);
    }
    public void eliminarPorId(Long id){
        turnoRepository.deleteById(id);
    }

}
