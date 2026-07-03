package com.example.colegio_backend.controller;

import com.example.colegio_backend.Entity.Noticia;
import com.example.colegio_backend.service.NoticiaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
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
@RequestMapping("/api/noticias")
@Tag(name = "Noticias", description = "CRUD de noticias del colegio")
public class NoticiaController {

	private final NoticiaService noticiaService;

	public NoticiaController(NoticiaService noticiaService) {
		this.noticiaService = noticiaService;
	}

	@GetMapping
	@Operation(summary = "Listar noticias", description = "Obtiene todas las noticias registradas")
	public ResponseEntity<List<Noticia>> listarNoticias() {
		return ResponseEntity.ok(noticiaService.listarNoticias());
	}

	@GetMapping("/{id}")
	@Operation(summary = "Obtener noticia por ID", description = "Obtiene una noticia usando su identificador")
	public ResponseEntity<Noticia> obtenerNoticiaPorId(@PathVariable Long id) {
		return noticiaService.obtenerNoticiaPorId(id)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}

	@PostMapping
	@Operation(summary = "Crear noticia", description = "Registra una nueva noticia")
	public ResponseEntity<Noticia> crearNoticia(@Valid @RequestBody Noticia noticia) {
		return ResponseEntity.status(HttpStatus.CREATED).body(noticiaService.crearNoticia(noticia));
	}

	@PutMapping("/{id}")
	@Operation(summary = "Actualizar noticia", description = "Actualiza los datos de una noticia existente")
	public ResponseEntity<Noticia> actualizarNoticia(@PathVariable Long id, @Valid @RequestBody Noticia noticia) {
		return noticiaService.actualizarNoticia(id, noticia)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}

	@DeleteMapping("/{id}")
	@Operation(summary = "Eliminar noticia", description = "Elimina una noticia usando su identificador")
	public ResponseEntity<Void> eliminarNoticia(@PathVariable Long id) {
		if (!noticiaService.eliminarNoticia(id)) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.noContent().build();
	}
}
