package com.example.colegio_backend.repository;

import com.example.colegio_backend.Entity.Noticia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoticiaRepository extends JpaRepository<Noticia, Long> {
}
