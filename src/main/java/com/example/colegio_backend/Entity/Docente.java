package com.example.colegio_backend.Entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Entity
@Schema(description = "Entidad que representa a un docente del colegio")
public class Docente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Schema(description = "Identificador unico autogenerado del docente", example = "1")
	private Long id;

	@NotBlank
	@Schema(description = "Nombre completo del docente", example = "Maria Fernandez")
	private String nombre;

	@NotBlank
	@Schema(description = "Materia que imparte el docente", example = "Matematicas")
	private String materia;

	@Schema(description = "Especialidad profesional o academica del docente", example = "Algebra y geometria")
	private String especialidad;

	@Email
	@Schema(description = "Correo electronico de contacto del docente", example = "maria.fernandez@colegio.edu")
	private String correo;

	@Schema(description = "Telefono de contacto del docente", example = "70000000")
	private String telefono;

	@Schema(description = "URL de la foto del docente", example = "https://example.com/docente.jpg")
	private String fotoUrl;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getMateria() {
		return materia;
	}

	public void setMateria(String materia) {
		this.materia = materia;
	}

	public String getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getFotoUrl() {
		return fotoUrl;
	}

	public void setFotoUrl(String fotoUrl) {
		this.fotoUrl = fotoUrl;
	}
}
