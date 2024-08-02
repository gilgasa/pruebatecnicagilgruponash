package com.nach.pruebatecnica.gil.test.repository;

import com.nach.pruebatecnica.gil.test.model.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio para la entidad Empleado.
 * Proporciona operaciones CRUD para la entidad Empleado.
 * <p>
 * Gilberto García Sánchez
 * gilgasan1@gmail.com
 */
@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {
}
