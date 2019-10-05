package br.com.caelum.ingresso.rest;

import java.util.Optional;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import br.com.caelum.ingresso.model.DetalhesDoFilme;
import br.com.caelum.ingresso.model.Filme;

@Component
public class OmdbClient {
	
	private RestTemplate client = new RestTemplate();

	OmdbClient (RestTemplate client) {
		this.client = client;
	}
	
	public OmdbClient() {
		// TODO Auto-generated constructor stub
	}
	
	public Optional<DetalhesDoFilme> request(Filme filme) {
								
		
		String titulo = filme.getNome().replace(" ", "+");
		
		String url = String.format("https://omdb-fj22.herokuapp.com/movie?title=%s", titulo);
		
		try {
			DetalhesDoFilme detalhesDoFilme = client.getForObject(url, DetalhesDoFilme.class);
			
			return Optional.ofNullable(detalhesDoFilme);
			
		} catch (RestClientException e) {
			
			return Optional.empty();
			
		}
		
	}
	
}
