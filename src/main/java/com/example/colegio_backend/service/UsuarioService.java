package com.example.colegio_backend.service;

import com.example.colegio_backend.Entity.Usuario;
import com.example.colegio_backend.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

	private final UsuarioRepository usuarioRepository;

	public UsuarioService(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}

	public List<Usuario> listarUsuarios() {
		return usuarioRepository.findAll();
	}

	public Optional<Usuario> obtenerUsuarioPorId(Long id) {
		return usuarioRepository.findById(id);
	}

	public Usuario crearUsuario(Usuario usuario) {
		usuario.setId(null);
		return usuarioRepository.save(usuario);
	}

	public Optional<Usuario> actualizarUsuario(Long id, Usuario usuarioActualizado) {
		return usuarioRepository.findById(id)
				.map(usuario -> {
					usuario.setUsername(usuarioActualizado.getUsername());
					usuario.setPassword(usuarioActualizado.getPassword());
					return usuarioRepository.save(usuario);
				});
	}

	public boolean eliminarUsuario(Long id) {
		if (!usuarioRepository.existsById(id)) {
			return false;
		}

		usuarioRepository.deleteById(id);
		return true;
	}

	public boolean login(String username, String password) {
		return usuarioRepository.findByUsernameAndPassword(username, password).isPresent();
	}
}
