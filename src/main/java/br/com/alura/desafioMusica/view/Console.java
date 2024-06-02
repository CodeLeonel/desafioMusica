package br.com.alura.desafioMusica.view;

public class Console {

	public static void menu() {
		
		String menu = """
				
				### Screen Sound Músicas ###
				
				1 - Cadastrar artistas
				2 - Cadastrar músicas
				3 - Listar músicas
				4 - Pesquisar músicas por artista
				5 - Pesquisar dados sobre um artista
				
				0 - Saída
				
				Digite uma opção:""";
		
		System.out.print(menu);
		
	}
	
}
