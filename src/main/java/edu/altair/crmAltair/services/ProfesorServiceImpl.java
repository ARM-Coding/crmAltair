package edu.altair.crmAltair.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.altair.crmAltair.dtos.ProfesorRequestDto;
import edu.altair.crmAltair.dtos.ProfesorResponseDto;
import edu.altair.crmAltair.entities.Departamento;
import edu.altair.crmAltair.entities.Profesor;
import edu.altair.crmAltair.exceptions.ProfesorNotFoundException;
import edu.altair.crmAltair.repositories.DepartamentoRepository;
import edu.altair.crmAltair.repositories.ProfesorRespository;

@Service
public class ProfesorServiceImpl implements ProfesorService {
	
	// mapToResponse
	
	public ProfesorResponseDto mapToResponseDto(Profesor profesor) {
		return new ProfesorResponseDto(
				profesor.getNombre(),
				profesor.getApellidos(),
				profesor.getDni(),
				profesor.getEmailCentro(),
				profesor.getEmailPersonal(),
				profesor.getTelefonoPersonal(),
				profesor.getDepartamento().getIdDepartamento(),
				profesor.getDepartamento().getNombre()
				);
	}
	
	// Inyectamos el repositorio con un constructor
	
	private final ProfesorRespository profesorRepository;
	private final DepartamentoRepository departamentoRepository;
	
	public ProfesorServiceImpl(ProfesorRespository profesorRepository, 
							DepartamentoRepository departamentoRepository) {
		super();
		this.profesorRepository = profesorRepository;
		this.departamentoRepository = departamentoRepository;
	}

	@Override
	@Transactional(readOnly = true)
	public List<ProfesorResponseDto> obtenerTodos() {
		// TODO Auto-generated method stub
		return profesorRepository.findAll()
		.stream()
		.map(this::mapToResponseDto)
		.toList();
	}

	@Override
	@Transactional(readOnly = true)
	public ProfesorResponseDto obtenerById(Long id) {
		// TODO Auto-generated method stub
		Profesor profesor = profesorRepository.findById(id)
				.orElseThrow(() -> new ProfesorNotFoundException
				("El profesor con la id " + id + " no existe"));
		return mapToResponseDto(profesor);
	}

	@Override
	@Transactional
	public ProfesorResponseDto create(ProfesorRequestDto requestDto) {
		// TODO Auto-generated method stub
		if (profesorRepository.existsByDni(requestDto.dni())) {
			throw new Error();
		}
		
		Profesor profesor = new Profesor(
				null,
				requestDto.nombre(),
				requestDto.apellidos(),
				requestDto.dni(),
				requestDto.emailCentro(),
				requestDto.emailPersonal(),
				requestDto.telefonoPersonal(),
				requestDto.departamento()
				);
		
		Profesor saved = profesorRepository.save(profesor);
		
		return mapToResponseDto(saved);
	}

	@Override
	@Transactional
	public ProfesorResponseDto update(Long id, ProfesorRequestDto requestDto) {
		// TODO Auto-generated method stub
		
		Profesor profesorExistente = profesorRepository.findById(id)
				.orElseThrow();
		
		if (!profesorExistente.getDni().equalsIgnoreCase(requestDto.dni()) &&
				profesorRepository.existsByDni(requestDto.dni())) {
			throw new Error();
		}
		
		profesorExistente.setNombre(requestDto.nombre());
		profesorExistente.setApellidos(requestDto.apellidos());
		profesorExistente.setDni(requestDto.dni());
		profesorExistente.setEmailCentro(requestDto.emailCentro());
		profesorExistente.setEmailPersonal(requestDto.emailPersonal());
		profesorExistente.setTelefonoPersonal(requestDto.telefonoPersonal());
		profesorExistente.setDepartamento(requestDto.departamento());
		
		Profesor saved = profesorRepository.save(profesorExistente);
		
		return mapToResponseDto(saved);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
		if (!profesorRepository.existsById(id)) {
			throw new Error();
		}
		
		profesorRepository.deleteById(id);
		
	}

	@Override
	@Transactional(readOnly = true)
	public List<ProfesorResponseDto> obtenerByDepartamento(Long idDepartamento) {
		// TODO Auto-generated method stub
		return profesorRepository.findByDepartamento_IdDepartamento(idDepartamento)
				.stream()
				.map(this::mapToResponseDto)
				.toList();
	}

}
