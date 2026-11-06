package edu.altair.crmAltair.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "profesor", schema = "crm", uniqueConstraints = {
		@UniqueConstraint(name = "uk_profesor_dni", columnNames = "dni")
})
public class Profesor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_profesor")
	private Long idProfesor;
	
	@Column(name = "nombre", nullable = false)
	private String nombre;
	
	@Column(name = "apellidos", nullable = false)
	private String apellidos;
	
	@Column(name = "dni")
	private String dni;
	
	@Column(name = "emailCentro")
	private String emailCentro;
	
	@Column(name = "emailPersonal")
	private String emailPersonal;
	
	@Column(name = "telefonoPersonal")
	private Long telefonoPersonal;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "id_departamento", foreignKey = 
		@ForeignKey(name = "fk_profesores_departamento"))
	private Departamento departamento;
	
	// Contructores (Vacío y el custom)
	
	public Profesor() {};
	
	public Profesor(Long idProfesor, String nombre, String apellidos, String dni, String emailCentro,
			String emailPersonal, Long telefonoPersonal, Departamento departamento) {
		super();
		this.idProfesor = idProfesor;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.dni = dni;
		this.emailCentro = emailCentro;
		this.emailPersonal = emailPersonal;
		this.telefonoPersonal = telefonoPersonal;
		this.departamento = departamento;
	}
	
	// Getters & Setters
	
	public Long getIdProfesor() {
		return idProfesor;
	}

	public void setIdProfesor(Long idProfesor) {
		this.idProfesor = idProfesor;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getEmailCentro() {
		return emailCentro;
	}

	public void setEmailCentro(String emailCentro) {
		this.emailCentro = emailCentro;
	}

	public String getEmailPersonal() {
		return emailPersonal;
	}

	public void setEmailPersonal(String emailPersonal) {
		this.emailPersonal = emailPersonal;
	}

	public Long getTelefonoPersonal() {
		return telefonoPersonal;
	}

	public void setTelefonoPersonal(Long telefonoPersonal) {
		this.telefonoPersonal = telefonoPersonal;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}
	
}
