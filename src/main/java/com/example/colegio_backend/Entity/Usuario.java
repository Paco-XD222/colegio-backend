package com.example.colegio_backend.Entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

@Entity
@Schema(description = "Entidad que representa un usuario para login basico")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Schema(description = "Identificador unico autogenerado del usuario", example = "1")
	private Long id;

	@NotBlank
	@Column(nullable = false, unique = true)
	@Schema(description = "Nombre de usuario unico para iniciar sesion", example = "admin")
	private String username;

	@NotBlank
	@Column(nullable = false)
	@Schema(description = "Contrasena del usuario", example = "admin123")
	private String password;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
