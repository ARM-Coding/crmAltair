package edu.altair.crmAltair.dtos;

public record DepartamentoRequestDto(Long idDepartamento,
									Long codigo,
									String nombre,
									String descripcion,
									Long telefono) {
	
}
