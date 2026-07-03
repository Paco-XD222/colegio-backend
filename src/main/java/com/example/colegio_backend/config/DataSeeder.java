package com.example.colegio_backend.config;

import com.example.colegio_backend.Entity.Contacto;
import com.example.colegio_backend.Entity.Docente;
import com.example.colegio_backend.Entity.Noticia;
import com.example.colegio_backend.Entity.Promocion;
import com.example.colegio_backend.Entity.Usuario;
import com.example.colegio_backend.repository.ContactoRepository;
import com.example.colegio_backend.repository.DocenteRepository;
import com.example.colegio_backend.repository.NoticiaRepository;
import com.example.colegio_backend.repository.PromocionRepository;
import com.example.colegio_backend.repository.UsuarioRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class DataSeeder {

	@Bean
	CommandLineRunner cargarDatosIniciales(UsuarioRepository usuarioRepository,
			NoticiaRepository noticiaRepository,
			DocenteRepository docenteRepository,
			PromocionRepository promocionRepository,
			ContactoRepository contactoRepository) {
		return args -> {
			cargarUsuarios(usuarioRepository);
			cargarNoticias(noticiaRepository);
			cargarDocentes(docenteRepository);
			cargarPromociones(promocionRepository);
			cargarContactos(contactoRepository);
		};
	}

	private void cargarUsuarios(UsuarioRepository usuarioRepository) {
		if (usuarioRepository.count() > 0) {
			return;
		}

		Usuario usuario = new Usuario();
		usuario.setUsername("admin");
		usuario.setPassword("admin123");

		usuarioRepository.save(usuario);
	}

	private void cargarNoticias(NoticiaRepository noticiaRepository) {
		if (noticiaRepository.count() > 0) {
			return;
		}

		Noticia bienvenida = new Noticia();
		bienvenida.setTitulo("Bienvenidos al sistema web del colegio");
		bienvenida.setDescripcion("Sistema administrable para publicar información institucional.");
		bienvenida.setFecha("2026-07-02");
		bienvenida.setImagenUrl("https://via.placeholder.com/600x300");

		Noticia comunicado = new Noticia();
		comunicado.setTitulo("Comunicado institucional");
		comunicado.setDescripcion("Se informa a la comunidad educativa revisar las novedades del colegio.");
		comunicado.setFecha("2026-07-02");
		comunicado.setImagenUrl("https://via.placeholder.com/600x300");

		noticiaRepository.saveAll(List.of(bienvenida, comunicado));
	}

	private void cargarDocentes(DocenteRepository docenteRepository) {
		if (docenteRepository.count() > 0) {
			return;
		}

		Docente juan = new Docente();
		juan.setNombre("Juan Perez");
		juan.setMateria("Matemáticas");
		juan.setEspecialidad("Educación secundaria");
		juan.setCorreo("juan.perez@colegio.edu.bo");
		juan.setTelefono("70000001");
		juan.setFotoUrl("https://via.placeholder.com/300");

		Docente maria = new Docente();
		maria.setNombre("Maria Lopez");
		maria.setMateria("Lenguaje");
		maria.setEspecialidad("Comunicación y literatura");
		maria.setCorreo("maria.lopez@colegio.edu.bo");
		maria.setTelefono("70000002");
		maria.setFotoUrl("https://via.placeholder.com/300");

		docenteRepository.saveAll(List.of(juan, maria));
	}

	private void cargarPromociones(PromocionRepository promocionRepository) {
		if (promocionRepository.count() > 0) {
			return;
		}

		Promocion promocion2026 = new Promocion();
		promocion2026.setNombre("Promoción 2026");
		promocion2026.setAnio(2026);
		promocion2026.setDescripcion("Generación de estudiantes del Colegio Carlos Medinaceli.");
		promocion2026.setImagenUrl("https://via.placeholder.com/600x300");

		Promocion promocion2025 = new Promocion();
		promocion2025.setNombre("Promoción 2025");
		promocion2025.setAnio(2025);
		promocion2025.setDescripcion("Promoción destacada por sus actividades académicas y culturales.");
		promocion2025.setImagenUrl("https://via.placeholder.com/600x300");

		promocionRepository.saveAll(List.of(promocion2026, promocion2025));
	}

	private void cargarContactos(ContactoRepository contactoRepository) {
		if (contactoRepository.count() > 0) {
			return;
		}

		Contacto contacto = new Contacto();
		contacto.setNombre("Visitante de prueba");
		contacto.setCorreo("visitante@correo.com");
		contacto.setAsunto("Consulta general");
		contacto.setMensaje("Solicito información sobre actividades del colegio.");
		contacto.setFecha("2026-07-02");

		contactoRepository.save(contacto);
	}
}
