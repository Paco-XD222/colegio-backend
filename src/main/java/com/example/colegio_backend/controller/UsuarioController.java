package com.example.colegio_backend.controller;

import com.example.colegio_backend.Entity.Usuario;
import com.example.colegio_backend.service.UsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
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

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
@Tag(name = "Usuarios", description = "CRUD de usuarios y login basico")
public class UsuarioController {

	private final UsuarioService usuarioService;

	public UsuarioController(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}

	@GetMapping
	@Operation(summary = "Listar usuarios", description = "Obtiene todos los usuarios registrados")
	public ResponseEntity<List<Usuario>> listarUsuarios() {
		return ResponseEntity.ok(usuarioService.listarUsuarios());
	}

	@GetMapping("/{id}")
	@Operation(summary = "Obtener usuario por ID", description = "Obtiene un usuario usando su identificador")
	public ResponseEntity<Usuario> obtenerUsuarioPorId(@PathVariable Long id) {
		return usuarioService.obtenerUsuarioPorId(id)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}

	@PostMapping
	@Operation(summary = "Crear usuario", description = "Registra un nuevo usuario")
	public ResponseEntity<Usuario> crearUsuario(@Valid @RequestBody Usuario usuario) {
		return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.crearUsuario(usuario));
	}

	@PutMapping("/{id}")
	@Operation(summary = "Actualizar usuario", description = "Actualiza los datos de un usuario existente")
	public ResponseEntity<Usuario> actualizarUsuario(@PathVariable Long id, @Valid @RequestBody Usuario usuario) {
		return usuarioService.actualizarUsuario(id, usuario)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}

	@DeleteMapping("/{id}")
	@Operation(summary = "Eliminar usuario", description = "Elimina un usuario usando su identificador")
	public ResponseEntity<Void> eliminarUsuario(@PathVariable Long id) {
		if (!usuarioService.eliminarUsuario(id)) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.noContent().build();
	}

	@PostMapping("/login")
	@Operation(summary = "Login basico", description = "Valida username y password sin Spring Security ni JWT")
	public ResponseEntity<String> login(@Valid @RequestBody LoginRequest loginRequest) {
		if (usuarioService.login(loginRequest.getUsername(), loginRequest.getPassword())) {
			return ResponseEntity.ok("Login correcto");
		}

		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Login incorrecto");
	}

	public static class LoginRequest {

		@NotBlank
		private String username;

		@NotBlank
		private String password;

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
}
