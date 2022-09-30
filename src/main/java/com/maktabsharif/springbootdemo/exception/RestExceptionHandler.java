package com.maktabsharif.springbootdemo.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(value = BadRequestRuntimeException.class)
    public ResponseEntity<ExceptionData> handleBadRequestException(BadRequestRuntimeException ex) {
        return ResponseEntity.badRequest()
                .body(
                        new ExceptionData(
                                ex.getMessage(),
                                LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME)
                        )
                );
    }

    @ExceptionHandler(value = EntityNotFoundRuntimeException.class)
    public ResponseEntity<ExceptionData> handleEntityNotFoundException(EntityNotFoundRuntimeException ex) {
        return new ResponseEntity<>(
                new ExceptionData(
                        ex.getMessage(),
                        LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME)
                ),
                HttpStatus.NOT_FOUND
        );
    }

}

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
class ExceptionData implements Serializable {
    private String message;
    private String date;
}