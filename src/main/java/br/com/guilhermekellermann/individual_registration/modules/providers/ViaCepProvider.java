package br.com.guilhermekellermann.individual_registration.modules.providers;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ViaCepProvider {
    
    private final String viaCepBaseUrl = "https://viacep.com.br/ws/";

    private final RestTemplate restTemplate;

    public ViaCepProvider(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public ViaCepResponse consultarCep(String cep) {
        String url = viaCepBaseUrl + cep + "/json/";
        return restTemplate.getForObject(url, ViaCepResponse.class);
    }
}
