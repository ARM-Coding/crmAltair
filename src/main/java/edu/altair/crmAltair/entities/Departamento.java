package edu.altair.crmAltair.entities;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "departamento", schema = "crm", uniqueConstraints = {
		@UniqueConstraint(name = "uk_departamento_codigo", columnNames = "codigo")
})
public class Departamento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_departamento")
	private Long idDepartamento;
	
	@Column(name = "codigo", unique = true, nullable = false)
	private Long codigo;
	
	@Column(name = "nombre", nullable = false)
	private String nombre;
	
	@Column(name = "descripcion")
	private String descripcion;
	
	@Column(name = "telefono")
	private Long telefono;

	// Contructores

		// Vacío
	public Departamento() {};
	
		// Custom
	public Departamento(Long idDepartamento, Long codigo, String nombre, String descripcion, Long telefono,
			List<Profesor> profesores) {
		super();
		this.idDepartamento = idDepartamento;
		this.codigo = codigo;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.telefono = telefono;
	}

	
	// Getters y Setters
	
	public Long getIdDepartamento() {
		return idDepartamento;
	}

	public void setIdDepartamento(Long idDepartamento) {
		this.idDepartamento = idDepartamento;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Long getTelefono() {
		return telefono;
	}

	public void setTelefono(Long telefono) {
		this.telefono = telefono;
	}

}
