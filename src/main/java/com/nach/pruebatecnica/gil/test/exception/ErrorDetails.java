package com.nach.pruebatecnica.gil.test.exception;

import java.util.Date;

/**
 * Clase que representa los detalles de un error para las respuestas de excepción.
 * <p>
 * Gilberto García Sánchez
 * gilgasan1@gmail.com
 */
public class ErrorDetails {
    private Date timestamp;
    private String message;
    private String details;

    /**
     * Constructor con parámetros.
     *
     * @param timestamp Fecha y hora del error.
     * @param message   Mensaje de error.
     * @param details   Detalles adicionales del error.
     */
    public ErrorDetails(Date timestamp, String message, String details) {
        super();
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
    }

    // Getters y Setters

    /**
     * Obtiene la fecha y hora del error.
     *
     * @return Fecha y hora del error.
     */
    public Date getTimestamp() {
        return timestamp;
    }

    /**
     * Establece la fecha y hora del error.
     *
     * @param timestamp Fecha y hora del error.
     */
    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    /**
     * Obtiene el mensaje de error.
     *
     * @return Mensaje de error.
     */
    public String getMessage() {
        return message;
    }

    /**
     * Establece el mensaje de error.
     *
     * @param message Mensaje de error.
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * Obtiene los detalles adicionales del error.
     *
     * @return Detalles adicionales del error.
     */
    public String getDetails() {
        return details;
    }

    /**
     * Establece los detalles adicionales del error.
     *
     * @param details Detalles adicionales del error.
     */
    public void setDetails(String details) {
        this.details = details;
    }
}
