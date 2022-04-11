package com.ferrianwebsterdictionary.app.demo.model;

import org.springframework.http.HttpStatus;

import java.time.Instant;

public class ApiError {
    private Integer httpStatusCode;
    private HttpStatus httpStatus;
    private String message;
    private String description;
    private Instant timestamp;

    public ApiError(Integer httpStatusCode, HttpStatus httpStatus, String message, String description, Instant timestamp) {
        this.httpStatusCode = httpStatusCode;
        this.httpStatus = httpStatus;
        this.message = message;
        this.description = description;
        this.timestamp = timestamp;
    }

    public ApiError() {
    }

    public static Builder builder() {
        return new Builder();
    }

    public Integer getHttpStatusCode() {
        return httpStatusCode;
    }

    public void setHttpStatusCode(Integer httpStatusCode) {
        this.httpStatusCode = httpStatusCode;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Instant timestamp) {
        this.timestamp = timestamp;
    }

    public static class Builder {
        private Integer httpStatusCode;
        private HttpStatus httpStatus;
        private String message;
        private String description;
        private Instant timestamp;

        public Builder withHttpStatusCode(Integer httpStatusCode) {
            this.httpStatusCode = httpStatusCode;
            return this;
        }

        public Builder withHttpStatus(HttpStatus httpStatus) {
            this.httpStatus = httpStatus;
            return this;
        }

        public Builder withMessage(String message) {
            this.message = message;
            return this;
        }

        public Builder withDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder withTimestamp(Instant timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        public ApiError build() {
            return new ApiError(this.httpStatusCode, this.httpStatus, this.message, this.description, this.timestamp);
        }
    }
}
