package com.clinica1.service;

import com.clinica1.dao.DomicilioRespository;
import com.clinica1.entities.Domicilio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class DomicilioService {
    @Autowired
    private  DomicilioRespository domicilioRepository;

//    @Autowired
//    public DomicilioService(DomicilioRespository domicilioRepository) {
//        this.domicilioRepository = domicilioRepository;
//    }

    public Domicilio guardar(Domicilio d){
        return domicilioRepository.save(d);
    }
    public Optional<Domicilio> buscar(Integer id){
        return Optional.of(domicilioRepository.getById(Long.valueOf(id)));
    }
    public List<Domicilio> buscarTodos(){
        return domicilioRepository.findAll();
    }
    public void eliminar(Integer id){
        domicilioRepository.deleteById(Long.valueOf(id));
    }

}

