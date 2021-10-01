package com.clinica1.dto;

import com.clinica1.entities.Odontologo;
import com.clinica1.entities.Paciente;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class TurnoDTO {

    private Long id;
    private Paciente paciente;
    private Odontologo odontologo;
    private Date date;

}
