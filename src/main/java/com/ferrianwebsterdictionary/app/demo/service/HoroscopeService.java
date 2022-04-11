package com.ferrianwebsterdictionary.app.demo.service;

import com.ferrianwebsterdictionary.app.demo.dto.HoroscopeResponseDto;
import org.springframework.http.HttpEntity;

public interface HoroscopeService {
    HoroscopeResponseDto getHoroscope(String sign, String day);

    HttpEntity<String> createHttpEntity();
}
