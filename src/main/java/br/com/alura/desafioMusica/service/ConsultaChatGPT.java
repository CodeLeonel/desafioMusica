package br.com.alura.desafioMusica.service;

import com.theokanning.openai.completion.CompletionRequest;
import com.theokanning.openai.service.OpenAiService;

public class ConsultaChatGPT {
	public static String obterDetalhesArtista(String nomeArtista) {
		OpenAiService service = new OpenAiService(System.getenv("APIKEYOPENAI"));

		CompletionRequest requisicao = CompletionRequest.builder().model("gpt-3.5-turbo-instruct")
				.prompt("diga em detalhes sobre este artista: " + nomeArtista).maxTokens(1000).temperature(0.7).build();

		var resposta = service.createCompletion(requisicao);
		return resposta.getChoices().get(0).getText();
	}
}
