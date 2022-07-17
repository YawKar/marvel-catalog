package com.yawkar.marvelcatalog.view;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ExceptionView {

    private String message;
    private LocalDateTime timestamp;
    @JsonProperty("status_code")
    private int statusCode;
}
