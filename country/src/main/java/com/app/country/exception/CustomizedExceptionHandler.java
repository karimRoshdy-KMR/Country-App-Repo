package com.app.country.exception;

import org.hibernate.exception.JDBCConnectionException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice(basePackages = "com.app.country.bus")
public class CustomizedExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(JDBCConnectionException.class)
    public final ResponseEntity<Object> handleJDBCException(Exception ex, WebRequest request) throws Exception {
        ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), "Internal Error", request.getDescription(false));
        return new ResponseEntity(exceptionResponse , HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(CountryNotFoundException.class)
    public final ResponseEntity<Object> handleNotFoundException(Exception ex, WebRequest request) throws Exception {
        ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false));
            return new ResponseEntity(exceptionResponse , HttpStatus.INTERNAL_SERVER_ERROR);
    }


}
