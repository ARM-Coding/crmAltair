package edu.altair.crmAltair.services;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.altair.crmAltair.dtos.DepartamentoRequestDto;
import edu.altair.crmAltair.dtos.DepartamentoResponseDto;
import edu.altair.crmAltair.entities.Departamento;
import edu.altair.crmAltair.exceptions.CodigoAlreadyExistsException;
import edu.altair.crmAltair.exceptions.DepartamentoNotFoundException;
import edu.altair.crmAltair.repositories.DepartamentoRepository;

@Service
public class DepartamentoServiceImpl implements DepartamentoService {

	private DepartamentoResponseDto mapToResponseDto(Departamento departamento) {
		return new DepartamentoResponseDto(
				departamento.getIdDepartamento(),
				departamento.getCodigo(),
				departamento.getNombre(),
				departamento.getDescripcion(),
				departamento.getTelefono()
				);
	}

	private final DepartamentoRepository departamentoRepository;

	public DepartamentoServiceImpl(DepartamentoRepository departamentoRepository) {
		super();
		this.departamentoRepository = departamentoRepository;
	}

	@Override
	@Transactional(readOnly = true)
	public List<DepartamentoResponseDto> obtenerTodos() {

		return departamentoRepository.findAll()
		.stream()
		.map(this::mapToResponseDto)
		.toList();

	}

	@Override
	@Transactional(readOnly = true)
	public DepartamentoResponseDto obtenerPorId(Long id) {

		Departamento departamento = departamentoRepository.findById(id).
				orElseThrow(() -> new DepartamentoNotFoundException("Departamento no encontrado con el ID: " + id));

		return mapToResponseDto(departamento);
	}

	@Override
	@Transactional
	public DepartamentoResponseDto create(DepartamentoRequestDto requestDto) {

		if (departamentoRepository.existsByCodigo(requestDto.codigo())) {
			throw new CodigoAlreadyExistsException("Ya existe un departamento registrado con el código: " + requestDto.codigo());
		}

		Departamento newDepartamento = new Departamento(
				null,
				requestDto.codigo(),
				requestDto.nombre(),
				requestDto.descripcion(),
				requestDto.telefono(), null
				);

		Departamento saved = departamentoRepository.save(newDepartamento);

		return mapToResponseDto(saved);
	}

	@Override
	@Transactional
	public DepartamentoResponseDto update(Long id, DepartamentoRequestDto requestDto) {

		Departamento departamentoExistenteUpdate = departamentoRepository.findById(id)
				.orElseThrow(() -> new DepartamentoNotFoundException("Departamento no encontrado con el ID: " + id));

		if (!departamentoExistenteUpdate.getCodigo().equals(requestDto.codigo()) && departamentoRepository.existsByCodigo(requestDto.codigo())) {
			throw new CodigoAlreadyExistsException("El código " + requestDto.codigo() + " ya está en uso por otro departamento.");
		}

		departamentoExistenteUpdate.setCodigo(requestDto.codigo());
		departamentoExistenteUpdate.setNombre(requestDto.nombre());
		departamentoExistenteUpdate.setDescripcion(requestDto.descripcion());
		departamentoExistenteUpdate.setTelefono(requestDto.telefono());

		Departamento updated = departamentoRepository.save(departamentoExistenteUpdate);

		return mapToResponseDto(updated);
	}

	@Override
	@Transactional
	public void delete(Long id) {

		if (!departamentoRepository.existsById(id)) {
			throw new DepartamentoNotFoundException("Imposible eliminar. Departamento no encontrado con el ID: " + id);
		}

		departamentoRepository.deleteById(id);

	}

}
