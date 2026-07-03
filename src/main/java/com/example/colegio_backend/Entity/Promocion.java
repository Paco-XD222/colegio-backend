package com.example.colegio_backend.Entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Schema(description = "Entidad que representa una promocion del colegio")
public class Promocion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Schema(description = "Identificador unico autogenerado de la promocion", example = "1")
	private Long id;

	@NotBlank
	@Schema(description = "Nombre de la promocion", example = "Promocion Bicentenario")
	private String nombre;

	@NotNull
	@Schema(description = "Anio de la promocion", example = "2026")
	private Integer anio;

	@Schema(description = "Descripcion de la promocion", example = "Estudiantes graduados de la gestion 2026")
	private String descripcion;

	@Schema(description = "URL de la imagen asociada a la promocion", example = "https://example.com/promocion.jpg")
	private String imagenUrl;

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

	public Integer getAnio() {
		return anio;
	}

	public void setAnio(Integer anio) {
		this.anio = anio;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getImagenUrl() {
		return imagenUrl;
	}

	public void setImagenUrl(String imagenUrl) {
		this.imagenUrl = imagenUrl;
	}
}
