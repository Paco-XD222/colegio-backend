package com.example.colegio_backend.repository;

import com.example.colegio_backend.Entity.Docente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocenteRepository extends JpaRepository<Docente, Long> {
}
