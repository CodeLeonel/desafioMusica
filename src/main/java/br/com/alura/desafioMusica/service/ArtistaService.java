package br.com.alura.desafioMusica.service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import br.com.alura.desafioMusica.modelo.Artista;
import br.com.alura.desafioMusica.modelo.Musica;
import br.com.alura.desafioMusica.modelo.TipoArtista;
import br.com.alura.desafioMusica.repository.ArtistaRepository;

public class ArtistaService {

	private ArtistaRepository repositorio;
	
	public ArtistaService(ArtistaRepository repositorio) {
		this.repositorio = repositorio;
	}
	
	public void inserirArtista(String nome, TipoArtista tipo) {
		
		Artista novoArtista = new Artista(nome,tipo);
		
		this.repositorio.save(novoArtista);
		
	}
	
	public Map<Long,String> listarArtistas() {
		
		var mapArtistas = this.repositorio.findAll().stream()
			.collect(Collectors
					.toMap(a -> a.getId(), a -> a.getNome()));
		
		return mapArtistas;
	}
	
	public List<Musica> listarMusicas() {
		
		var listaMusicas = this.repositorio.findAll()
				.stream()
				.flatMap(a -> a.getMusicas().stream())
				.collect(Collectors.toList());
		
		return listaMusicas;
	}
	
	public void inserirMusica(Long idArtista, String nomeMusica) {
		
		var artistaOpt = repositorio.findById(idArtista);
		
		if(artistaOpt.isPresent()) {
			
			var artista = artistaOpt.get();
			
			Musica novaMusica = new Musica(nomeMusica);
			
			artista.inserirMusica(novaMusica);
			
			repositorio.save(artista);
			
		}
		
	}
	
}
