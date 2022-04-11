package com.ferrianwebsterdictionary.app.demo.controllerAdvice;

import com.ferrianwebsterdictionary.app.demo.exception.DictionaryWordNotFoundException;
import com.ferrianwebsterdictionary.app.demo.exception.NoWordFoundInMeaningIndexException;
import com.ferrianwebsterdictionary.app.demo.model.ApiError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.Instant;

@ControllerAdvice
public class ApiDictionaryControllerAdvice {

    @ExceptionHandler(NoWordFoundInMeaningIndexException.class)
    public ResponseEntity<ApiError> handleNoWordFoundInMeaningIndexException(WebRequest webRequest, RuntimeException exception) {
        ApiError apiError = ApiError.builder()
                .withHttpStatusCode(HttpStatus.NOT_FOUND.value())
                .withHttpStatus(HttpStatus.NOT_FOUND)
                .withMessage(exception.getMessage())
                .withDescription(webRequest.getDescription(true))
                .withTimestamp(Instant.now())
                .build();

        return new ResponseEntity<>(apiError, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(DictionaryWordNotFoundException.class)
    public ResponseEntity<ApiError> handleHttpClientErrorException(WebRequest webRequest, RuntimeException exception) {
        ApiError apiError = ApiError.builder()
                .withHttpStatusCode(HttpStatus.NOT_FOUND.value())
                .withHttpStatus(HttpStatus.NOT_FOUND)
                .withMessage(exception.getMessage())
                .withDescription(webRequest.getDescription(true))
                .withTimestamp(Instant.now())
                .build();

        return new ResponseEntity<>(apiError, HttpStatus.NOT_FOUND);
    }



}
