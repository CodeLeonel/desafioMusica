package br.com.alura.desafioMusica;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.alura.desafioMusica.repository.ArtistaRepository;

@SpringBootApplication
public class DesafioMusicaApplication implements CommandLineRunner {

	private ArtistaRepository repositorio;
	
	public static void main(String[] args) {
		SpringApplication.run(DesafioMusicaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		
		
	}

}
