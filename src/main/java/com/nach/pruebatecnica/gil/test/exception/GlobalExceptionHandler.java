package com.nach.pruebatecnica.gil.test.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import java.util.Date;

/**
 * Clase para manejar excepciones globalmente en la aplicación.
 * <p>
 * Gilberto García Sánchez
 * gilgasan1@gmail.com
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Maneja excepciones de tipo ResourceNotFoundException.
     *
     * @param ex      La excepción lanzada.
     * @param request La solicitud web donde ocurrió la excepción.
     * @return Una respuesta con detalles del error y el estado HTTP 404.
     */
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> resourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }

    /**
     * Maneja todas las demás excepciones no capturadas específicamente.
     *
     * @param ex      La excepción lanzada.
     * @param request La solicitud web donde ocurrió la excepción.
     * @return Una respuesta con detalles del error y el estado HTTP 500.
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> globalExceptionHandler(Exception ex, WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
