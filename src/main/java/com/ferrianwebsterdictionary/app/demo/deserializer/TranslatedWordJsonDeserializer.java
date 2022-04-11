package com.ferrianwebsterdictionary.app.demo.deserializer;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.ferrianwebsterdictionary.app.demo.dto.TranslationResponseDto;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.Map;

public class TranslatedWordJsonDeserializer extends StdDeserializer<TranslationResponseDto> {


    public TranslatedWordJsonDeserializer() {
        this(null);
    }

    public TranslatedWordJsonDeserializer(Class<?> vc) {
        super(vc);
    }


    @Override
    public TranslationResponseDto deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JacksonException {
        ObjectCodec codec = jsonParser.getCodec();
        JsonNode node = codec.readTree(jsonParser);

        JsonNode fromNode = node.get("from");
        String from = fromNode.asText();

        JsonNode originalTextNode = node.get("original_text");
        String originalText = originalTextNode.asText();

        JsonNode statusNode = node.get("status");
        Integer status = statusNode.asInt();

        JsonNode toNode = node.get("to");
        String to = toNode.asText();

        JsonNode translatedCharactersNode = node.get("translated_characters");
        Integer translatedCharacters = translatedCharactersNode.asInt();

        JsonNode translatedTextNode = node.get("translated_text");
        String translatedText = translatedTextNode.toString();

        return new TranslationResponseDto(from, originalText, status, to, translatedCharacters, retrieveDeserializedText(translatedText));
    }

    public String retrieveDeserializedText(String json) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            Map<String, String> map = objectMapper.readValue(json, new TypeReference<Map<String,String>>(){});
            Map.Entry<String,String> entry = map.entrySet().iterator().next();
            return URLDecoder.decode(entry.getValue(), StandardCharsets.UTF_8.toString());
        } catch (JsonProcessingException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return null;
    }
}
