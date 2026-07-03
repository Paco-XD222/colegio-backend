package com.example.colegio_backend.controller;

import com.example.colegio_backend.Entity.Contacto;
import com.example.colegio_backend.service.ContactoService;
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
@RequestMapping("/api/contactos")
@Tag(name = "Contactos", description = "CRUD de mensajes de contacto del colegio")
public class ContactoController {

	private final ContactoService contactoService;

	public ContactoController(ContactoService contactoService) {
		this.contactoService = contactoService;
	}

	@GetMapping
	@Operation(summary = "Listar contactos", description = "Obtiene todos los mensajes de contacto registrados")
	public ResponseEntity<List<Contacto>> listarContactos() {
		return ResponseEntity.ok(contactoService.listarContactos());
	}

	@GetMapping("/{id}")
	@Operation(summary = "Obtener contacto por ID", description = "Obtiene un mensaje de contacto usando su identificador")
	public ResponseEntity<Contacto> obtenerContactoPorId(@PathVariable Long id) {
		return contactoService.obtenerContactoPorId(id)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}

	@PostMapping
	@Operation(summary = "Crear contacto", description = "Registra un nuevo mensaje de contacto")
	public ResponseEntity<Contacto> crearContacto(@Valid @RequestBody Contacto contacto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(contactoService.crearContacto(contacto));
	}

	@PutMapping("/{id}")
	@Operation(summary = "Actualizar contacto", description = "Actualiza los datos de un mensaje de contacto existente")
	public ResponseEntity<Contacto> actualizarContacto(@PathVariable Long id, @Valid @RequestBody Contacto contacto) {
		return contactoService.actualizarContacto(id, contacto)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}

	@DeleteMapping("/{id}")
	@Operation(summary = "Eliminar contacto", description = "Elimina un mensaje de contacto usando su identificador")
	public ResponseEntity<Void> eliminarContacto(@PathVariable Long id) {
		if (!contactoService.eliminarContacto(id)) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.noContent().build();
	}
}
