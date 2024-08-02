package com.nach.pruebatecnica.gil.test.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Excepción personalizada para recursos no encontrados.
 * Se lanza cuando un empleado no se encuentra en la base de datos.
 * <p>
 * Gilberto García Sánchez
 * gilgasan1@gmail.com
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

    /**
     * Constructor que acepta un mensaje de error.
     *
     * @param message Mensaje de error.
     */
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
