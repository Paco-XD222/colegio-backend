package com.example.colegio_backend.service;

import com.example.colegio_backend.Entity.Docente;
import com.example.colegio_backend.repository.DocenteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DocenteService {

	private final DocenteRepository docenteRepository;

	public DocenteService(DocenteRepository docenteRepository) {
		this.docenteRepository = docenteRepository;
	}

	public List<Docente> listarDocentes() {
		return docenteRepository.findAll();
	}

	public Optional<Docente> obtenerDocentePorId(Long id) {
		return docenteRepository.findById(id);
	}

	public Docente crearDocente(Docente docente) {
		docente.setId(null);
		return docenteRepository.save(docente);
	}

	public Optional<Docente> actualizarDocente(Long id, Docente docenteActualizado) {
		return docenteRepository.findById(id)
				.map(docente -> {
					docente.setNombre(docenteActualizado.getNombre());
					docente.setMateria(docenteActualizado.getMateria());
					docente.setEspecialidad(docenteActualizado.getEspecialidad());
					docente.setCorreo(docenteActualizado.getCorreo());
					docente.setTelefono(docenteActualizado.getTelefono());
					docente.setFotoUrl(docenteActualizado.getFotoUrl());
					return docenteRepository.save(docente);
				});
	}

	public boolean eliminarDocente(Long id) {
		if (!docenteRepository.existsById(id)) {
			return false;
		}

		docenteRepository.deleteById(id);
		return true;
	}
}
