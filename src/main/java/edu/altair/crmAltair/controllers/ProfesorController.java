package edu.altair.crmAltair.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.altair.crmAltair.dtos.ProfesorRequestDto;
import edu.altair.crmAltair.dtos.ProfesorResponseDto;
import edu.altair.crmAltair.services.ProfesorService;

@RestController
@RequestMapping("/api/profesores")
public class ProfesorController {
	
	// Inyectamos el servicio mediante el constructor
	
	private final ProfesorService profesorService;

	public ProfesorController(ProfesorService profesorService) {
		super();
		this.profesorService = profesorService;
	}
	
	@GetMapping
	public ResponseEntity<List<ProfesorResponseDto>> obtenerTodos() {
		return ResponseEntity.ok(profesorService.obtenerTodos());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ProfesorResponseDto> obtenerById(@PathVariable Long id) {
		return ResponseEntity.ok(profesorService.obtenerById(id));
	}
	
	@GetMapping("/{idDepartamento}")
	public ResponseEntity<List<ProfesorResponseDto>> obtenerByDepartamento(@PathVariable Long idDepartamento) {
		return ResponseEntity.ok(profesorService.obtenerByDepartamento(idDepartamento));
	}
	
	@PostMapping
	public ResponseEntity<ProfesorResponseDto> create(@RequestBody ProfesorRequestDto requestDto) {
		ProfesorResponseDto creado = profesorService.create(requestDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(creado);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<ProfesorResponseDto> update(@PathVariable Long id, 
			@RequestBody ProfesorRequestDto requestDto) {
		return ResponseEntity.ok(profesorService.update(id, requestDto));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<ProfesorResponseDto> delete(@PathVariable Long id) {
		profesorService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
