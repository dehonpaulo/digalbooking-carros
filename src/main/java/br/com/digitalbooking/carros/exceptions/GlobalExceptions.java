package br.com.digitalbooking.carros.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

@ControllerAdvice
public class GlobalExceptions {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<StandardError> entityNotFoundHandlerMethod(EntityNotFoundException ex, HttpServletRequest request) {
        StandardError se = new StandardError(Instant.now(), 404, "Resource not found", ex.getMessage(), request.getRequestURI());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(se);
    }

    @ExceptionHandler(UnreportedEssentialFieldException.class)
    public ResponseEntity<StandardError> unreportedEssentialFieldHandlerMethod(UnreportedEssentialFieldException ex, HttpServletRequest request) {
        StandardError se = new StandardError(Instant.now(), 422, "Missing essential attribute", ex.getMessage(), request.getRequestURI());
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(se);
    }
}
