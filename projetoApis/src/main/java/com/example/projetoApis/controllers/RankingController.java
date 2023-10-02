package com.example.projetoApis.controllers;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.projetoApis.entities.InfoRank;

@RestController
public class RankingController {
    
    private String apiUrl = "https://servicodados.ibge.gov.br/api/v2/censos/nomes/ranking/?decada=";

    @GetMapping("/decada/{ano}")
    public List<InfoRank> getInfos(@PathVariable String ano) {
        String url = apiUrl + ano;

        RestTemplate restTemplate = new RestTemplate();
        
        InfoRank[] infoRankArray = restTemplate.getForObject(url, InfoRank[].class);

        if (infoRankArray != null) {
            return Arrays.asList(infoRankArray);
        } else {
            return Collections.emptyList();
        }

    }
}
