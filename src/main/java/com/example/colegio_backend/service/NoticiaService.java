package com.example.colegio_backend.service;

import com.example.colegio_backend.Entity.Noticia;
import com.example.colegio_backend.repository.NoticiaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NoticiaService {

	private final NoticiaRepository noticiaRepository;

	public NoticiaService(NoticiaRepository noticiaRepository) {
		this.noticiaRepository = noticiaRepository;
	}

	public List<Noticia> listarNoticias() {
		return noticiaRepository.findAll();
	}

	public Optional<Noticia> obtenerNoticiaPorId(Long id) {
		return noticiaRepository.findById(id);
	}

	public Noticia crearNoticia(Noticia noticia) {
		noticia.setId(null);
		return noticiaRepository.save(noticia);
	}

	public Optional<Noticia> actualizarNoticia(Long id, Noticia noticiaActualizada) {
		return noticiaRepository.findById(id)
				.map(noticia -> {
					noticia.setTitulo(noticiaActualizada.getTitulo());
					noticia.setDescripcion(noticiaActualizada.getDescripcion());
					noticia.setFecha(noticiaActualizada.getFecha());
					noticia.setImagenUrl(noticiaActualizada.getImagenUrl());
					return noticiaRepository.save(noticia);
				});
	}

	public boolean eliminarNoticia(Long id) {
		if (!noticiaRepository.existsById(id)) {
			return false;
		}

		noticiaRepository.deleteById(id);
		return true;
	}
}
