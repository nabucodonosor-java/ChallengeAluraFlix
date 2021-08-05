package com.alura.flix.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.alura.flix.entities.Video;

public interface VideoRepository extends JpaRepository<Video, Long> {
	
	
	
	@Query("SELECT DISTINCT obj FROM Video obj WHERE (LOWER(obj.titulo) LIKE LOWER(CONCAT('%',:nome,'%'))) ")
	Page<Video> findVideoByTitulo(String nome, Pageable pageable);
	
}
