package br.com.alura.desafioMusica.modelo;

public enum TipoArtista {

	SOLO("solo"),
	DUPLA("dupla"),
	BANDA("banda");
	
	private String tipo;
	
	TipoArtista(String tipo) {
		this.tipo = tipo;
	}
	
	public static TipoArtista fromTipo(String tipo) {
		for(TipoArtista tipoArtista : TipoArtista.values()) {
			if(tipoArtista.tipo.equalsIgnoreCase(tipo)) {
				return tipoArtista;
			}
		}
		throw new IllegalArgumentException("Nenhum tipo de artista encontrado para a string fornecida: " + tipo);
	}
	
}
