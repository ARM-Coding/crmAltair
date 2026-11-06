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

import edu.altair.crmAltair.dtos.DepartamentoRequestDto;
import edu.altair.crmAltair.dtos.DepartamentoResponseDto;
import edu.altair.crmAltair.services.DepartamentoService;

@RestController
@RequestMapping("/api/departamentos")
public class DepartamentoController {
	
	private final DepartamentoService departamentoService;
	
	public DepartamentoController(DepartamentoService departamentoService) {
		this.departamentoService = departamentoService;
	}
	
	// Read All - GET /api/departamentos
	@GetMapping
	public ResponseEntity<List<DepartamentoResponseDto>> obtenerTodos() {
		return ResponseEntity.ok(departamentoService.obtenerTodos()); // HTTP 200 OK
	};
	
	// Read By Id - Get /api/departamentos/{id}
	@GetMapping("/{id}")
	public ResponseEntity<DepartamentoResponseDto> obtenerPorId(@PathVariable Long id) {
		return ResponseEntity.ok(departamentoService.obtenerPorId(id)); // HTTP 200 OK
	}
	
	// Create - Post /api/departamentos
	@PostMapping
	public ResponseEntity<DepartamentoResponseDto> crear(@RequestBody DepartamentoRequestDto requestDto) {
		DepartamentoResponseDto created = departamentoService.create(requestDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(created);
	}
	
	// Update - Put /api/departamentos/{id}
	@PutMapping("/{id}")
	public ResponseEntity<DepartamentoResponseDto> update(
			@PathVariable Long id,
			@RequestBody DepartamentoRequestDto requestDto
			) {
		DepartamentoResponseDto updated = departamentoService.update(id, requestDto);
		return ResponseEntity.ok(updated);
	}
	
	// Delete - Delete /api/departamentos/{id}
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		departamentoService.delete(id);
		return ResponseEntity.noContent().build(); //  HTTP 204 No Content
	}
}
