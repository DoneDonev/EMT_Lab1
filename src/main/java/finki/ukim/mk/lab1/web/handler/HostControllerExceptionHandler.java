package finki.ukim.mk.lab1.web.handler;

import finki.ukim.mk.lab1.model.exception.CountryNotFoundException;
import finki.ukim.mk.lab1.model.exception.HostNotFoundException;
import finki.ukim.mk.lab1.web.controller.HostController;
import finki.ukim.mk.lab1.web.dto.ApiError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice(assignableTypes = HostController.class)
public class HostControllerExceptionHandler {
    @ExceptionHandler(HostNotFoundException.class)
    public ResponseEntity<ApiError> HostNotFound(HostNotFoundException exception) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(ApiError.of(HttpStatus.NOT_FOUND, exception.getMessage()));
    }

    @ExceptionHandler(CountryNotFoundException.class)
    public ResponseEntity<ApiError> countryNotFound(CountryNotFoundException exception) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(ApiError.of(HttpStatus.NOT_FOUND, exception.getMessage()));
    }
}
