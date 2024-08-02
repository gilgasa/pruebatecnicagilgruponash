package com.nach.pruebatecnica.gil.test.service;

import com.nach.pruebatecnica.gil.test.model.Empleado;
import com.nach.pruebatecnica.gil.test.repository.EmpleadoRepository;
import com.nach.pruebatecnica.gil.test.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Servicio para gestionar operaciones relacionadas con Empleado.
 * <p>
 * Gilberto García Sánchez
 * gilgasan1@gmail.com
 */
@Service
public class EmpleadoService {

    @Autowired
    private EmpleadoRepository empleadoRepository;

    /**
     * Obtiene todos los empleados.
     *
     * @return Lista de todos los empleados.
     */
    public List<Empleado> getAllEmpleados() {
        return empleadoRepository.findAll();
    }

    /**
     * Obtiene un empleado por su ID.
     *
     * @param id ID del empleado.
     * @return Empleado con el ID especificado.
     * @throws ResourceNotFoundException si el empleado no es encontrado.
     */
    public Empleado getEmpleadoById(Long id) {
        return empleadoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Empleado no encontrado con id: " + id));
    }

    /**
     * Crea un nuevo empleado.
     *
     * @param empleado Datos del nuevo empleado.
     * @return Empleado creado.
     */
    public Empleado createEmpleado(Empleado empleado) {
        return empleadoRepository.save(empleado);
    }

    /**
     * Actualiza un empleado existente.
     *
     * @param id              ID del empleado a actualizar.
     * @param empleadoDetails Datos actualizados del empleado.
     * @return Empleado actualizado.
     * @throws ResourceNotFoundException si el empleado no es encontrado.
     */
    public Empleado updateEmpleado(Long id, Empleado empleadoDetails) {
        Empleado empleado = getEmpleadoById(id);

        empleado.setNombre(empleadoDetails.getNombre());
        empleado.setPuesto(empleadoDetails.getPuesto());
        empleado.setSalario(empleadoDetails.getSalario());
        empleado.setFechaContratacion(empleadoDetails.getFechaContratacion());

        return empleadoRepository.save(empleado);
    }

    /**
     * Elimina un empleado por su ID.
     *
     * @param id ID del empleado a eliminar.
     * @throws ResourceNotFoundException si el empleado no es encontrado.
     */
    public void deleteEmpleado(Long id) {
        Empleado empleado = getEmpleadoById(id);
        empleadoRepository.delete(empleado);
    }
}
