package com.example.colegio_backend.service;

import com.example.colegio_backend.Entity.Promocion;
import com.example.colegio_backend.repository.PromocionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PromocionService {

	private final PromocionRepository promocionRepository;

	public PromocionService(PromocionRepository promocionRepository) {
		this.promocionRepository = promocionRepository;
	}

	public List<Promocion> listarPromociones() {
		return promocionRepository.findAll();
	}

	public Optional<Promocion> obtenerPromocionPorId(Long id) {
		return promocionRepository.findById(id);
	}

	public Promocion crearPromocion(Promocion promocion) {
		promocion.setId(null);
		return promocionRepository.save(promocion);
	}

	public Optional<Promocion> actualizarPromocion(Long id, Promocion promocionActualizada) {
		return promocionRepository.findById(id)
				.map(promocion -> {
					promocion.setNombre(promocionActualizada.getNombre());
					promocion.setAnio(promocionActualizada.getAnio());
					promocion.setDescripcion(promocionActualizada.getDescripcion());
					promocion.setImagenUrl(promocionActualizada.getImagenUrl());
					return promocionRepository.save(promocion);
				});
	}

	public boolean eliminarPromocion(Long id) {
		if (!promocionRepository.existsById(id)) {
			return false;
		}

		promocionRepository.deleteById(id);
		return true;
	}
}
