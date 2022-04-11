package com.ferrianwebsterdictionary.app.demo.errorHandler;

import com.ferrianwebsterdictionary.app.demo.exception.DictionaryWordNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.ResponseErrorHandler;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;

import static org.springframework.http.HttpStatus.Series.CLIENT_ERROR;
import static org.springframework.http.HttpStatus.Series.SERVER_ERROR;

@Component
public class ApiDictionaryRestTemplateResponseErrorHandler implements ResponseErrorHandler {

    @Override
    public boolean hasError(ClientHttpResponse response) throws IOException {
        return (response.getStatusCode().series() == CLIENT_ERROR || response.getStatusCode().series() == SERVER_ERROR);
    }

    @Override
    public void handleError(ClientHttpResponse response) throws IOException {
        final HttpStatus statusCode = response.getStatusCode();

        switch (statusCode) {
            case NOT_FOUND:
                throw new DictionaryWordNotFoundException("Searched word was not found!");
            case BAD_REQUEST:
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Wrong provided credentials!");
            case UNSUPPORTED_MEDIA_TYPE:
                throw new ResponseStatusException(HttpStatus.UNSUPPORTED_MEDIA_TYPE, "Data was provided in wrong format");
        }
    }
}
