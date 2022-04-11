package com.ferrianwebsterdictionary.app.demo.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.ferrianwebsterdictionary.app.demo.deserializer.TranslatedWordJsonDeserializer;
import com.ferrianwebsterdictionary.app.demo.dto.TranslationRequestDto;
import com.ferrianwebsterdictionary.app.demo.dto.TranslationResponseDto;
import com.ferrianwebsterdictionary.app.demo.service.TranslationService;
import org.springframework.core.env.Environment;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TranslationServiceImpl implements TranslationService {

    private final RestTemplate restTemplate;
    private final Environment environment;

    public TranslationServiceImpl(RestTemplate restTemplate, Environment environment) {
        this.restTemplate = restTemplate;
        this.environment = environment;
    }

    @Override
    public TranslationResponseDto translate(TranslationRequestDto translationRequestDto) {
        String url = String.format(
                "%s?text=%s&to=%s&from=%s",
                environment.getProperty("translator.rapid.api.url"),
                translationRequestDto.getText(),
                translationRequestDto.getTo(),
                translationRequestDto.getFrom());

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, createHttpEntity(), String.class);

        return mapFromJsonToResponse(response.getBody());
    }

    @Override
    public TranslationResponseDto mapFromJsonToResponse(String json) {
        ObjectMapper mapper = new ObjectMapper();
        SimpleModule module = new SimpleModule("CustomWordDeserializer", new Version(1, 0, 0, null, null, null));
        module.addDeserializer(TranslationResponseDto.class, new TranslatedWordJsonDeserializer());
        mapper.registerModule(module);

        try {
            return mapper.readValue(json, TranslationResponseDto.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public HttpEntity<String> createHttpEntity() {
        HttpHeaders httpHeaders = new HttpHeaders();

        httpHeaders.set("x-rapidapi-host", environment.getProperty("translator.rapid.api.host"));
        httpHeaders.set("x-rapidapi-key", environment.getProperty("translator.rapid.api.key"));

        return new HttpEntity<>(httpHeaders);
    }
}
