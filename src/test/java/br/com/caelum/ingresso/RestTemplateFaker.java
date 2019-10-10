package br.com.caelum.ingresso;

import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

public class RestTemplateFaker extends RestTemplate {
	
	@Override
	public <T> T getForObject(String url, Class<T> responseType, Object... uriVariables) throws RestClientException {
		// TODO Auto-generated method stub
		System.out.println("Passei aqui!");
		throw new RestClientException("erro");
	}
}
