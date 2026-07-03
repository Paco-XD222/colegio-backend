package com.example.colegio_backend.controller;

import com.example.colegio_backend.Entity.Promocion;
import com.example.colegio_backend.service.PromocionService;
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
@RequestMapping("/api/promociones")
@Tag(name = "Promociones", description = "CRUD de promociones del colegio")
public class PromocionController {

	private final PromocionService promocionService;

	public PromocionController(PromocionService promocionService) {
		this.promocionService = promocionService;
	}

	@GetMapping
	@Operation(summary = "Listar promociones", description = "Obtiene todas las promociones registradas")
	public ResponseEntity<List<Promocion>> listarPromociones() {
		return ResponseEntity.ok(promocionService.listarPromociones());
	}

	@GetMapping("/{id}")
	@Operation(summary = "Obtener promocion por ID", description = "Obtiene una promocion usando su identificador")
	public ResponseEntity<Promocion> obtenerPromocionPorId(@PathVariable Long id) {
		return promocionService.obtenerPromocionPorId(id)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}

	@PostMapping
	@Operation(summary = "Crear promocion", description = "Registra una nueva promocion")
	public ResponseEntity<Promocion> crearPromocion(@Valid @RequestBody Promocion promocion) {
		return ResponseEntity.status(HttpStatus.CREATED).body(promocionService.crearPromocion(promocion));
	}

	@PutMapping("/{id}")
	@Operation(summary = "Actualizar promocion", description = "Actualiza los datos de una promocion existente")
	public ResponseEntity<Promocion> actualizarPromocion(@PathVariable Long id,
			@Valid @RequestBody Promocion promocion) {
		return promocionService.actualizarPromocion(id, promocion)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}

	@DeleteMapping("/{id}")
	@Operation(summary = "Eliminar promocion", description = "Elimina una promocion usando su identificador")
	public ResponseEntity<Void> eliminarPromocion(@PathVariable Long id) {
		if (!promocionService.eliminarPromocion(id)) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.noContent().build();
	}
}
