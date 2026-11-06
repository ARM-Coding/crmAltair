package edu.altair.crmAltair.services;

import java.util.List;

import edu.altair.crmAltair.dtos.ProfesorRequestDto;
import edu.altair.crmAltair.dtos.ProfesorResponseDto;

public interface ProfesorService {
	
	public List<ProfesorResponseDto> obtenerTodos();
	public ProfesorResponseDto obtenerById(Long id);
	public List<ProfesorResponseDto> obtenerByDepartamento(Long idDepartamento);
	public ProfesorResponseDto create(ProfesorRequestDto requestDto);
	public ProfesorResponseDto update(Long id, ProfesorRequestDto requestDto);
	
	void delete(Long id);
	
}
