package com.clinica1.service;

import com.clinica1.dao.PacienteRepository;
import com.clinica1.entities.Odontologo;
import com.clinica1.entities.Paciente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class PacienteServiceImpl {
    private final PacienteRepository pacienteRepository;

    @Autowired
    public PacienteServiceImpl(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    public Optional<Paciente> buscarPorID(Long id){
        return pacienteRepository.findById(id);
    }

    public List<Paciente> buscarTodos(){
        return pacienteRepository.findAll();
    }

    public Paciente registarPaciente(Paciente paciente){
        if(paciente!=null){
                return pacienteRepository.save(paciente);
        }
        return null;
    }
    public Paciente actualizar(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }
    public void eliminarPorId(Long id){
        pacienteRepository.deleteById(id);
    }

}
