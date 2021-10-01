package com.clinica1.service;

import com.clinica1.dao.OdontologoRepository;
import com.clinica1.entities.Odontologo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OdontologoServiceImpl {

    private OdontologoRepository odontologoRepository;
    @Autowired
    public OdontologoServiceImpl(OdontologoRepository odontologoRepository) {
        this.odontologoRepository = odontologoRepository;
    }
    public Optional<Odontologo> buscarPorID(Long id){
        return odontologoRepository.findById(id);
    }


    public List<Odontologo> buscarTodos(){
        return odontologoRepository.findAll();
    }
    public Odontologo registrarOdontologo(Odontologo odontologo){
        if(odontologo!=null){
        return odontologoRepository.save(odontologo);
        }
        return new Odontologo();
    }
   public Odontologo actualizar(Odontologo odontologo) {
        return odontologoRepository.save(odontologo);
    }
    public void eliminarPorId(Long id){
           odontologoRepository.deleteById(id);
    }



}
