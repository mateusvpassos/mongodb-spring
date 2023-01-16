package br.com.mateus.study.endpoint.exception;

import java.time.LocalDateTime;

import javax.persistence.EntityNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(value = { IllegalArgumentException.class })
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ResponseEntity<HandlerErrorMessage> resourceNotFoundException(final IllegalArgumentException ex) {
        HandlerErrorMessage errorMessage = new HandlerErrorMessage(HttpStatus.BAD_REQUEST, LocalDateTime.now(),
                ex.getMessage(), "Invalid field(s)");
        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = { EntityNotFoundException.class })
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ResponseEntity<HandlerErrorMessage> resourceNotFoundException(final EntityNotFoundException ex) {
        HandlerErrorMessage errorMessage = new HandlerErrorMessage(HttpStatus.NOT_FOUND, LocalDateTime.now(),
                ex.getMessage(), "Resource not found");
        return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
    }
}
