package com.ferrianwebsterdictionary.app.demo.service;

import com.ferrianwebsterdictionary.app.demo.dto.TranslationRequestDto;
import com.ferrianwebsterdictionary.app.demo.dto.TranslationResponseDto;
import org.springframework.http.HttpEntity;

public interface TranslationService {
    TranslationResponseDto translate(TranslationRequestDto translationRequestDto);
    TranslationResponseDto mapFromJsonToResponse(String json);
    HttpEntity<String> createHttpEntity();
}
