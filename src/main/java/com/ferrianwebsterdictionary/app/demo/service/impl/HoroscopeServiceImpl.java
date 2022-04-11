package com.ferrianwebsterdictionary.app.demo.service.impl;

import com.ferrianwebsterdictionary.app.demo.dto.HoroscopeResponseDto;
import com.ferrianwebsterdictionary.app.demo.service.HoroscopeService;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.sql.SQLDataException;

@Service
public class HoroscopeServiceImpl implements HoroscopeService {

    private final RestTemplate restTemplate;
    private final Environment environment;

    public HoroscopeServiceImpl(RestTemplate restTemplate, Environment environment) {
        this.restTemplate = restTemplate;
        this.environment = environment;
    }

    @Override
    public HoroscopeResponseDto getHoroscope(String sign, String day) {
        ResponseEntity<HoroscopeResponseDto> responseEntity = restTemplate.exchange(
                String.format("%s/?sign=%s&day=%s", environment.getProperty("horoscope.rapid.api.url"), sign, day),
                HttpMethod.POST,
                createHttpEntity(),
                HoroscopeResponseDto.class
        );

        return responseEntity.getBody();
    }

    @Override
    public HttpEntity<String> createHttpEntity() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("x-rapidapi-host", environment.getProperty("horoscope.rapid.api.host"));
        httpHeaders.set("x-rapidapi-key", environment.getProperty("translator.rapid.api.key"));

        return new HttpEntity<>(httpHeaders);
    }
}
