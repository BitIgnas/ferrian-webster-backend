package com.ferrianwebsterdictionary.app.demo.controller;

import com.ferrianwebsterdictionary.app.demo.dto.HoroscopeResponseDto;
import com.ferrianwebsterdictionary.app.demo.service.HoroscopeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v2/horoscope")
public class HoroscopeController {

    private final HoroscopeService horoscopeService;

    public HoroscopeController(HoroscopeService horoscopeService) {
        this.horoscopeService = horoscopeService;
    }

    @PostMapping("/{horoscope}/{day}")
    public ResponseEntity<HoroscopeResponseDto> getHoroscope(@PathVariable("horoscope") String horoscope,
                                                             @PathVariable("day") String day) {
        return ResponseEntity.ok().body(horoscopeService.getHoroscope(horoscope, day));

    }

}
