package com.example.colegio_backend.Entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

@Entity
@Schema(description = "Entidad que representa una noticia publicada por el colegio")
public class Noticia {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Schema(description = "Identificador unico autogenerado de la noticia", example = "1")
	private Long id;

	@NotBlank
	@Schema(description = "Titulo de la noticia", example = "Inicio de inscripciones")
	private String titulo;

	@NotBlank
	@Schema(description = "Descripcion o contenido principal de la noticia", example = "Las inscripciones se habilitan desde el lunes.")
	private String descripcion;

	@Schema(description = "Fecha asociada a la noticia", example = "2026-07-02")
	private String fecha;

	@Schema(description = "URL de la imagen asociada a la noticia", example = "https://example.com/noticia.jpg")
	private String imagenUrl;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getImagenUrl() {
		return imagenUrl;
	}

	public void setImagenUrl(String imagenUrl) {
		this.imagenUrl = imagenUrl;
	}
}
