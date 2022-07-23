package com.yawkar.marvelcatalog.controller.view;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@Accessors(chain = true)
public class ExceptionView {

    private String message;
    private LocalDateTime timestamp;
    @JsonProperty("status_code")
    private int statusCode;
}
