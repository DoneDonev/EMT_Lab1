package finki.ukim.mk.lab1.web.handler;

import finki.ukim.mk.lab1.model.exception.CountryNotFoundException;
import finki.ukim.mk.lab1.web.controller.CountryController;
import finki.ukim.mk.lab1.web.dto.ApiError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice(assignableTypes = CountryController.class)
public class CountryControllerExceptionHandler {
    @ExceptionHandler(CountryNotFoundException.class)
    public ResponseEntity<ApiError> countryNotFound(CountryNotFoundException exception) {
        System.out.println(exception.getMessage());
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(ApiError.of(HttpStatus.NOT_FOUND, exception.getMessage()));
    }
}
