package com.example.colegio_backend.Entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Entity
@Schema(description = "Entidad que representa un mensaje de contacto enviado al colegio")
public class Contacto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Schema(description = "Identificador unico autogenerado del contacto", example = "1")
	private Long id;

	@NotBlank
	@Schema(description = "Nombre de la persona que envia el mensaje", example = "Juan Perez")
	private String nombre;

	@NotBlank
	@Email
	@Schema(description = "Correo electronico de la persona que envia el mensaje", example = "juan.perez@example.com")
	private String correo;

	@Schema(description = "Asunto del mensaje de contacto", example = "Consulta sobre inscripciones")
	private String asunto;

	@NotBlank
	@Schema(description = "Contenido del mensaje de contacto", example = "Quisiera recibir informacion sobre las inscripciones.")
	private String mensaje;

	@Schema(description = "Fecha en la que se registro el mensaje", example = "2026-07-02")
	private String fecha;

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

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getAsunto() {
		return asunto;
	}

	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
}
