package br.com.alura.desafioMusica.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.alura.desafioMusica.modelo.Artista;

public interface ArtistaRepository extends JpaRepository<Artista, Long> {

}
