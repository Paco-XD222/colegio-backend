package com.example.colegio_backend.service;

import com.example.colegio_backend.Entity.Contacto;
import com.example.colegio_backend.repository.ContactoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactoService {

	private final ContactoRepository contactoRepository;

	public ContactoService(ContactoRepository contactoRepository) {
		this.contactoRepository = contactoRepository;
	}

	public List<Contacto> listarContactos() {
		return contactoRepository.findAll();
	}

	public Optional<Contacto> obtenerContactoPorId(Long id) {
		return contactoRepository.findById(id);
	}

	public Contacto crearContacto(Contacto contacto) {
		contacto.setId(null);
		return contactoRepository.save(contacto);
	}

	public Optional<Contacto> actualizarContacto(Long id, Contacto contactoActualizado) {
		return contactoRepository.findById(id)
				.map(contacto -> {
					contacto.setNombre(contactoActualizado.getNombre());
					contacto.setCorreo(contactoActualizado.getCorreo());
					contacto.setAsunto(contactoActualizado.getAsunto());
					contacto.setMensaje(contactoActualizado.getMensaje());
					contacto.setFecha(contactoActualizado.getFecha());
					return contactoRepository.save(contacto);
				});
	}

	public boolean eliminarContacto(Long id) {
		if (!contactoRepository.existsById(id)) {
			return false;
		}

		contactoRepository.deleteById(id);
		return true;
	}
}
