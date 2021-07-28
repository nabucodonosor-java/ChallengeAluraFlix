package com.alura.flix.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alura.flix.entities.Video;

public interface VideoRepository extends JpaRepository<Video, Long> {

}
