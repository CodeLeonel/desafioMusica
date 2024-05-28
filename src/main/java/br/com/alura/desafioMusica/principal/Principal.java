package br.com.alura.desafioMusica.principal;

import br.com.alura.desafioMusica.repository.ArtistaRepository;
import br.com.alura.desafioMusica.service.ArtistaService;

public class Principal {

	private ArtistaService artistaService;
	
	public Principal(ArtistaRepository repositorio) {
		
		this.artistaService = new ArtistaService(repositorio);
		
	}
	
}
