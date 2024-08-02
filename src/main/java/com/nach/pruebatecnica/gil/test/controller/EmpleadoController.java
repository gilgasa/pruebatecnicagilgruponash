package com.nach.pruebatecnica.gil.test.controller;

import com.nach.pruebatecnica.gil.test.model.Empleado;
import com.nach.pruebatecnica.gil.test.service.EmpleadoService;
import com.nach.pruebatecnica.gil.test.exception.ResourceNotFoundException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Controlador REST para gestionar empleados.
 * Proporciona endpoints para operaciones CRUD.
 * <p>
 * Gilberto García Sánchez
 * gilgasan1@gmail.com
 */
@RestController
@RequestMapping("/api/empleados")
@Api(value = "Empleado Management System", description = "Operaciones para gestionar empleados")
public class EmpleadoController {

    @Autowired
    private EmpleadoService empleadoService;

    /**
     * Obtiene la lista de todos los empleados.
     *
     * @return Lista de empleados.
     */
    @ApiOperation(value = "Obtener lista de todos los empleados", response = List.class)
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Empleados obtenidos con éxito"),
        @ApiResponse(code = 500, message = "Error interno del servidor")
    })
    @GetMapping
    public List<Empleado> getAllEmpleados() {
        return empleadoService.getAllEmpleados();
    }

    /**
     * Obtiene los detalles de un empleado por su ID.
     *
     * @param id ID del empleado.
     * @return Empleado con el ID especificado.
     */
    @ApiOperation(value = "Obtener detalles de un empleado por ID", response = Empleado.class)
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Empleado obtenido con éxito"),
        @ApiResponse(code = 404, message = "Empleado no encontrado"),
        @ApiResponse(code = 500, message = "Error interno del servidor")
    })
    @GetMapping("/{id}")
    public ResponseEntity<Empleado> getEmpleadoById(
            @ApiParam(value = "ID del empleado a obtener", required = true, example = "1") @PathVariable Long id) {
        Empleado empleado = empleadoService.getEmpleadoById(id);
        if (empleado == null) {
            throw new ResourceNotFoundException("Empleado no encontrado con id: " + id);
        }
        return ResponseEntity.ok(empleado);
    }

    /**
     * Crea un nuevo empleado.
     *
     * @param empleado Datos del nuevo empleado.
     * @return Empleado creado.
     */
    @ApiOperation(value = "Crear un nuevo empleado")
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "Empleado creado con éxito"),
        @ApiResponse(code = 400, message = "Solicitud incorrecta"),
        @ApiResponse(code = 500, message = "Error interno del servidor")
    })
    @PostMapping
    public Empleado createEmpleado(
            @ApiParam(value = "Datos del nuevo empleado", required = true, example = "{\n  \"nombre\": \"Carlos López\",\n  \"puesto\": \"Ingeniero\",\n  \"salario\": 45000,\n  \"fechaContratacion\": \"2023-01-01\"\n}") @Valid @RequestBody Empleado empleado) {
        return empleadoService.createEmpleado(empleado);
    }

    /**
     * Actualiza un empleado existente.
     *
     * @param id              ID del empleado a actualizar.
     * @param empleadoDetails Datos actualizados del empleado.
     * @return Empleado actualizado.
     */
    @ApiOperation(value = "Actualizar un empleado existente")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Empleado actualizado con éxito"),
        @ApiResponse(code = 404, message = "Empleado no encontrado"),
        @ApiResponse(code = 500, message = "Error interno del servidor")
    })
    @PutMapping("/{id}")
    public ResponseEntity<Empleado> updateEmpleado(
            @ApiParam(value = "ID del empleado a actualizar", required = true, example = "1") @PathVariable Long id,
            @ApiParam(value = "Datos actualizados del empleado", required = true, example = "{\n  \"nombre\": \"Carlos López\",\n  \"puesto\": \"Ingeniero Senior\",\n  \"salario\": 50000,\n  \"fechaContratacion\": \"2023-01-01\"\n}") @Valid @RequestBody Empleado empleadoDetails) {
        Empleado empleado = empleadoService.getEmpleadoById(id);
        if (empleado == null) {
            throw new ResourceNotFoundException("Empleado no encontrado con id: " + id);
        }
        empleado.setNombre(empleadoDetails.getNombre());
        empleado.setPuesto(empleadoDetails.getPuesto());
        empleado.setSalario(empleadoDetails.getSalario());
        empleado.setFechaContratacion(empleadoDetails.getFechaContratacion());
        Empleado updatedEmpleado = empleadoService.updateEmpleado(id, empleado);
        return ResponseEntity.ok(updatedEmpleado);
    }

    /**
     * Elimina un empleado por su ID.
     *
     * @param id ID del empleado a eliminar.
     * @return Respuesta vacía con código de estado 204.
     */
    @ApiOperation(value = "Eliminar un empleado")
    @ApiResponses(value = {
        @ApiResponse(code = 204, message = "Empleado eliminado con éxito"),
        @ApiResponse(code = 404, message = "Empleado no encontrado"),
        @ApiResponse(code = 500, message = "Error interno del servidor")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmpleado(
            @ApiParam(value = "ID del empleado a eliminar", required = true, example = "1") @PathVariable Long id) {
        Empleado empleado = empleadoService.getEmpleadoById(id);
        if (empleado == null) {
            throw new ResourceNotFoundException("Empleado no encontrado con id: " + id);
        }
        empleadoService.deleteEmpleado(id);
        return ResponseEntity.noContent().build();
    }
}
