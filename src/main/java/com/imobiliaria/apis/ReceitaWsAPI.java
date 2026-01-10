package com.imobiliaria.apis;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ReceitaWsAPI {
    private static final String RECEITA_WS_URL = "https://receitaws.com.br/v1/cnpj/";

    public DadosCnpj consultaCnpj(String cnpj) throws Exception {
        RestTemplate restTemplate = new RestTemplate();
        String url = RECEITA_WS_URL + cnpj;
        return restTemplate.getForObject(url, DadosCnpj.class);
    }
}
