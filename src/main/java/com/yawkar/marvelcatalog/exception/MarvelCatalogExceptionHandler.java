package com.yawkar.marvelcatalog.exception;

import com.yawkar.marvelcatalog.view.ExceptionView;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class MarvelCatalogExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({ComicNotFoundException.class, HeroNotFoundException.class})
    protected ResponseEntity<Object> handleEntityNotFound(RuntimeException ex, WebRequest request) {
        var exceptionView = new ExceptionView(ex.getMessage(), LocalDateTime.now(), HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<>(exceptionView, HttpStatus.NOT_FOUND);
    }
}
