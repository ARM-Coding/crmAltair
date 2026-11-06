package edu.altair.crmAltair.services;
import java.util.List;

import edu.altair.crmAltair.dtos.DepartamentoRequestDto;
import edu.altair.crmAltair.dtos.DepartamentoResponseDto;

public interface DepartamentoService {
	
	List<DepartamentoResponseDto> obtenerTodos();
	DepartamentoResponseDto obtenerPorId(Long id);
	DepartamentoResponseDto create(DepartamentoRequestDto requestDto);
	DepartamentoResponseDto update(Long id, DepartamentoRequestDto requestDto);
	
	void delete(Long id);
	
}
