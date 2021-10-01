package com.clinica1.dto;

import com.clinica1.entities.Paciente;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DomicilioDTO {
    private Long id;
    private String localidad;
    private String provincia;
    private Paciente paciente;
}
