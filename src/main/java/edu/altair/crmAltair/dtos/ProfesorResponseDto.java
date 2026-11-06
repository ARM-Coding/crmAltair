package edu.altair.crmAltair.dtos;

public record ProfesorResponseDto(String nombre,
								String apellidos,
								String dni,
								String emailCentro,
								String emailPersonal,
								Long telefonoPersonal,
								Long idDepartamento,
								String nombreDepartamento) {

}
