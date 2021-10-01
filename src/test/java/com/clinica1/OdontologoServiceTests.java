package com.clinica1;
import com.clinica1.service.OdontologoServiceImpl;
import com.clinica1.entities.Odontologo;
import org.junit.*;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringRunner.class)
@SpringBootTest
public class OdontologoServiceTests {


    @Autowired
    private OdontologoServiceImpl odontologoService;


    @Test
    public void agregarOdontologo() {
        Odontologo odontologo = odontologoService.registrarOdontologo(new Odontologo("Pepito", "Perez", 348971960));
        Assert.assertTrue(odontologo.getId() != null);

    }

    @Test
    public void eliminarOdontologoTest() {
        this.agregarOdontologo();
        odontologoService.eliminarPorId((long) 1);
        Assert.assertTrue(odontologoService.buscarPorID((long) 1).isEmpty());

    }

    @Test
    public void traerTodos() {
//        this.agregarOdontologo();
        List<Odontologo> odontologos = odontologoService.buscarTodos();
        Assert.assertTrue(odontologos.size() == 1);
    }

}
