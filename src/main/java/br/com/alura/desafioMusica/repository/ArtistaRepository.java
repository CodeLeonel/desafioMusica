package br.com.alura.desafioMusica.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.alura.desafioMusica.modelo.Artista;
import br.com.alura.desafioMusica.modelo.Musica;

public interface ArtistaRepository extends JpaRepository<Artista, Long> {

	@Query("SELECT m FROM Artista a JOIN a.musicas m WHERE a.id = :idArtista")
	public List<Musica> buscaMusicasPorArtista(Long idArtista);
	
}
