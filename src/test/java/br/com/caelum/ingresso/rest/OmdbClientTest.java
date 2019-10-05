package br.com.caelum.ingresso.rest;

import java.util.Optional;

import org.junit.Assert;
import org.junit.Test;

import br.com.caelum.ingresso.RestTemplateFaker;
import br.com.caelum.ingresso.model.DetalhesDoFilme;
import br.com.caelum.ingresso.model.Filme;

public class OmdbClientTest {
				
	@Test
	public void deve_retornar_detalhes_do_filme() {
		
		OmdbClient client = new OmdbClient();
		
		Filme filme = new Filme("Joker");
		
		Optional<DetalhesDoFilme> detalhe = client.request(filme);
		
		Assert.assertNotNull(detalhe);
		Assert.assertEquals("Joker", detalhe.get().getTitulo());
	}
	
	@Test
	public void nap_deve_retornar_quando_omdb_estiver_indisponivel() {
		
		OmdbClient client = new OmdbClient(new RestTemplateFaker());
		
		Filme filme = new Filme("Joker");
		
		Optional<DetalhesDoFilme> detalhe = client.request(filme);
		
		Assert.assertFalse(detalhe.isPresent());		
	}

}
