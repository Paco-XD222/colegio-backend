package com.example.colegio_backend.controller;

import com.example.colegio_backend.Entity.Docente;
import com.example.colegio_backend.service.DocenteService;
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
@RequestMapping("/api/docentes")
@Tag(name = "Docentes", description = "CRUD de docentes del colegio")
public class DocenteController {

	private final DocenteService docenteService;

	public DocenteController(DocenteService docenteService) {
		this.docenteService = docenteService;
	}

	@GetMapping
	@Operation(summary = "Listar docentes", description = "Obtiene todos los docentes registrados")
	public ResponseEntity<List<Docente>> listarDocentes() {
		return ResponseEntity.ok(docenteService.listarDocentes());
	}

	@GetMapping("/{id}")
	@Operation(summary = "Obtener docente por ID", description = "Obtiene un docente usando su identificador")
	public ResponseEntity<Docente> obtenerDocentePorId(@PathVariable Long id) {
		return docenteService.obtenerDocentePorId(id)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}

	@PostMapping
	@Operation(summary = "Crear docente", description = "Registra un nuevo docente")
	public ResponseEntity<Docente> crearDocente(@Valid @RequestBody Docente docente) {
		return ResponseEntity.status(HttpStatus.CREATED).body(docenteService.crearDocente(docente));
	}

	@PutMapping("/{id}")
	@Operation(summary = "Actualizar docente", description = "Actualiza los datos de un docente existente")
	public ResponseEntity<Docente> actualizarDocente(@PathVariable Long id, @Valid @RequestBody Docente docente) {
		return docenteService.actualizarDocente(id, docente)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}

	@DeleteMapping("/{id}")
	@Operation(summary = "Eliminar docente", description = "Elimina un docente usando su identificador")
	public ResponseEntity<Void> eliminarDocente(@PathVariable Long id) {
		if (!docenteService.eliminarDocente(id)) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.noContent().build();
	}
}
