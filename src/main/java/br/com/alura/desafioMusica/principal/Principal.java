package br.com.alura.desafioMusica.principal;

import java.util.Scanner;

import org.hibernate.internal.build.AllowSysOut;

import br.com.alura.desafioMusica.modelo.TipoArtista;
import br.com.alura.desafioMusica.repository.ArtistaRepository;
import br.com.alura.desafioMusica.service.ArtistaService;
import br.com.alura.desafioMusica.view.Console;

public class Principal {

	private ArtistaService artistaService;

	private Scanner leitura = new Scanner(System.in);

	public Principal(ArtistaRepository repositorio) {

		this.artistaService = new ArtistaService(repositorio);

	}

	public void menu() {

		int opcao = -1;
		while (opcao != 0) {
			Console.menu();
			opcao = leitura.nextInt();
			leitura.nextLine();
			opcoesMenu(opcao);
		}

	}

	private void opcoesMenu(int opcao) {

		switch (opcao) {

		case 0:
			System.out.println("Finalizando");
			break;
		case 1:
			System.out.print("Digite o nome do artista: ");
			var nomeArtista = leitura.nextLine();

			System.out.println("O artista é de qual tipo?");

			int tpCount = 0;
			for (var tipoArtista : TipoArtista.values()) {
				tpCount++;
				System.out.println(tpCount + " - " + tipoArtista.toString());
			}

			System.out.print("Escolha um dos tipos: ");
			var numTipo = leitura.nextInt();
			leitura.nextLine();
			String tipoArtistaString = "";

			switch (numTipo) {

			case 1:
				tipoArtistaString = "solo";
				break;
			case 2:
				tipoArtistaString = "dupla";
				break;
			case 3:
				tipoArtistaString = "banda";
				break;

			}

			TipoArtista tipoArtista = TipoArtista.fromTipo(tipoArtistaString);

			artistaService.inserirArtista(nomeArtista, tipoArtista);

			break;
		case 2:
			System.out.println("Primeiramente, escolha um artista cadastrado:");

			var artistas = artistaService.listarArtistas();

			for (var registro : artistas.entrySet()) {
				System.out.println(registro.getKey() + " - " + registro.getValue());
			}

			System.out.print("Escolha um dos artistas: ");
			var idArtista = leitura.nextLong();
			leitura.nextLine();

			System.out.print("Agora digite o nome da música: ");
			var nomeMusica = leitura.nextLine();

			artistaService.inserirMusica(idArtista, nomeMusica);

			break;
		case 3:
			var musicas = artistaService.listarMusicas();
			musicas.forEach(System.out::println);
			break;
		case 4:
			System.out.println("Primeiramente, escolha um artista cadastrado:");

			artistas = artistaService.listarArtistas();

			for (var registro : artistas.entrySet()) {
				System.out.println(registro.getKey() + " - " + registro.getValue());
			}

			System.out.print("Escolha um dos artistas: ");
			idArtista = leitura.nextLong();
			leitura.nextLine();

			var musicasDoArtista = artistaService.buscaMusicasPorArtista(idArtista);

			musicasDoArtista.forEach(System.out::println);

			break;
		case 5:
			System.out.print("Digite o nome de um artista: ");
			nomeArtista = leitura.nextLine();
			var resposta = artistaService.obterDeatlhesArtistaViaChatGPT(nomeArtista);
			System.out.println(resposta);
			break;
		default:
			System.out.println("Opção inválida");
			break;
		}

	}

}
