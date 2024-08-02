package com.nach.pruebatecnica.gil.test.model;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;

/**
 * Representa a un empleado en el sistema.
 * Contiene información básica como nombre, puesto, salario y fecha de contratación.
 * <p>
 * Gilberto García Sánchez
 * gilgasan1@gmail.com
 */
@Entity
public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre no puede estar vacío")
    private String nombre;

    @NotBlank(message = "El puesto no puede estar vacío")
    private String puesto;

    @Positive(message = "El salario debe ser un número positivo")
    private double salario;

    @PastOrPresent(message = "La fecha de contratación no puede ser futura")
    private LocalDate fechaContratacion;

    /**
     * Constructor vacío necesario para JPA.
     */
    public Empleado() {
    }

    /**
     * Constructor con parámetros.
     *
     * @param id                Identificador del empleado.
     * @param nombre            Nombre del empleado.
     * @param puesto            Puesto del empleado.
     * @param salario           Salario del empleado.
     * @param fechaContratacion Fecha de contratación del empleado.
     */
    public Empleado(Long id, String nombre, String puesto, double salario, LocalDate fechaContratacion) {
        this.id = id;
        this.nombre = nombre;
        this.puesto = puesto;
        this.salario = salario;
        this.fechaContratacion = fechaContratacion;
    }

    // Getters y Setters

    /**
     * Obtiene el ID del empleado.
     *
     * @return ID del empleado.
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece el ID del empleado.
     *
     * @param id ID del empleado.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre del empleado.
     *
     * @return Nombre del empleado.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del empleado.
     *
     * @param nombre Nombre del empleado.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el puesto del empleado.
     *
     * @return Puesto del empleado.
     */
    public String getPuesto() {
        return puesto;
    }

    /**
     * Establece el puesto del empleado.
     *
     * @param puesto Puesto del empleado.
     */
    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    /**
     * Obtiene el salario del empleado.
     *
     * @return Salario del empleado.
     */
    public double getSalario() {
        return salario;
    }

    /**
     * Establece el salario del empleado.
     *
     * @param salario Salario del empleado.
     */
    public void setSalario(double salario) {
        this.salario = salario;
    }

    /**
     * Obtiene la fecha de contratación del empleado.
     *
     * @return Fecha de contratación del empleado.
     */
    public LocalDate getFechaContratacion() {
        return fechaContratacion;
    }

    /**
     * Establece la fecha de contratación del empleado.
     *
     * @param fechaContratacion Fecha de contratación del empleado.
     */
    public void setFechaContratacion(LocalDate fechaContratacion) {
        this.fechaContratacion = fechaContratacion;
    }
}
