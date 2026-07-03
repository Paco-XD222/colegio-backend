package com.example.colegio_backend.repository;

import com.example.colegio_backend.Entity.Contacto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactoRepository extends JpaRepository<Contacto, Long> {
}
