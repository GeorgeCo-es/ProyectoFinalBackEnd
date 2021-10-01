package com.clinica1;


import com.clinica1.entities.Domicilio;
import com.clinica1.entities.Paciente;
import com.clinica1.service.DomicilioService;
import com.clinica1.service.PacienteServiceImpl;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringRunner.class)
@SpringBootTest
public class PacienteServiceTest {

    @Autowired
    private PacienteServiceImpl pacienteService;
    @Autowired
    private DomicilioService domicilioService;


    @Test
    public void agregarYBuscarPacienteTest() {
        Domicilio domi = new Domicilio("Calle", "123", "Temperley", "Buenos Aires");

        Paciente p = new Paciente("Tomas", "Pereyra", "12345678", new Date(), domicilioService.guardar(domi));
        pacienteService.registarPaciente(p);
        Assert.assertNotNull(pacienteService.buscarPorID(p.getId()));
    }

    @Test
    public void eliminarPacienteTest() {
        Domicilio domi = new Domicilio("Calle", "123", "Temperley", "Buenos Aires");
        Paciente p = new Paciente("Tomas", "Pereyra", "12345678", new Date(), domi);
        domicilioService.guardar(domi);
        pacienteService.registarPaciente(p);
        pacienteService.eliminarPorId((long)1);
        Assert.assertTrue(pacienteService.buscarPorID((long)1).isEmpty());

    }

    @Test
    public void traerTodos() {
        Domicilio domi = new Domicilio("Calle", "123", "Temperley", "Buenos Aires");
        Paciente p = new Paciente("Tomas", "Pereyra", "12345678", new Date(), domi);
        pacienteService.registarPaciente(p);
        List<Paciente> pacientes = pacienteService.buscarTodos();
        Assert.assertTrue(pacientes.size() == 1);
        System.out.println(pacientes);
    }


}
