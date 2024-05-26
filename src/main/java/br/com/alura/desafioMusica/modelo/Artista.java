package br.com.alura.desafioMusica.modelo;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="artistas")
public class Artista {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	
	private TipoArtista tipo;
	
	@OneToMany( mappedBy = "artista")
	private List<Musica> musicas = new ArrayList<>();
	
}
