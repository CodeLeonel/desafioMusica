package br.com.alura.desafioMusica.modelo;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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
	
	@OneToMany(mappedBy = "artista", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Musica> musicas = new ArrayList<>();
	
	public Artista() {
		
	}
	
	public Artista(String nome, TipoArtista tipo) {
		this.nome = nome;
		this.tipo = tipo;
	}
	
	public void inserirMusica(Musica musica) {
		musica.setArtista(this);
		musicas.add(musica);
	}

	@Override
	public String toString() {
		return "[id=" + id + ", nome=" + nome + ", tipo=" + tipo + ", musicas=" + musicas + "]";
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public TipoArtista getTipo() {
		return tipo;
	}

	public void setTipo(TipoArtista tipo) {
		this.tipo = tipo;
	}

	public Long getId() {
		return id;
	}

	public List<Musica> getMusicas() {
		return musicas;
	}
	
	
	
}
