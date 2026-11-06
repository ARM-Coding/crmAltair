package edu.altair.crmAltair.dtos;

import edu.altair.crmAltair.entities.Departamento;

public record ProfesorRequestDto(String nombre,
								String apellidos,
								String dni,
								String emailCentro,
								String emailPersonal,
								Long telefonoPersonal,
								Departamento departamento) {

}
