package com.ferrianwebsterdictionary.app.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class HoroscopeResponseDto {

    @JsonProperty("color")
    private String color;
    @JsonProperty("compatibility")
    private String compatibility;
    @JsonProperty("current_date")
    private String currentDate;
    @JsonProperty("date_range")
    private String dateRange;
    @JsonProperty("description")
    private String description;
    @JsonProperty("lucky_number")
    private String luckyNumber;
    @JsonProperty("lucky_time")
    private String luckyTime;
    @JsonProperty("mood")
    private String mood;

    public HoroscopeResponseDto(String color, String compatibility, String currentDate, String dateRange, String description, String luckyNumber, String luckyTime, String mood) {
        this.color = color;
        this.compatibility = compatibility;
        this.currentDate = currentDate;
        this.dateRange = dateRange;
        this.description = description;
        this.luckyNumber = luckyNumber;
        this.luckyTime = luckyTime;
        this.mood = mood;
    }

    public HoroscopeResponseDto() {
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getCompatibility() {
        return compatibility;
    }

    public void setCompatibility(String compatibility) {
        this.compatibility = compatibility;
    }

    public String getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(String currentDate) {
        this.currentDate = currentDate;
    }

    public String getDateRange() {
        return dateRange;
    }

    public void setDateRange(String dateRange) {
        this.dateRange = dateRange;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLuckyNumber() {
        return luckyNumber;
    }

    public void setLuckyNumber(String luckyNumber) {
        this.luckyNumber = luckyNumber;
    }

    public String getLuckyTime() {
        return luckyTime;
    }

    public void setLuckyTime(String luckyTime) {
        this.luckyTime = luckyTime;
    }

    public String getMood() {
        return mood;
    }

    public void setMood(String mood) {
        this.mood = mood;
    }
}
