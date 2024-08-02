package com.nach.pruebatecnica.gil.test.config;

import com.nach.pruebatecnica.gil.test.model.Empleado;
import com.nach.pruebatecnica.gil.test.repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;

/**
 * Clase para cargar datos iniciales en la base de datos al iniciar la aplicación.
 * <p>
 * Gilberto García Sánchez
 * gilgasan1@gmail.com
 */
@Configuration
public class DataLoader implements CommandLineRunner {

    @Autowired
    private EmpleadoRepository empleadoRepository;

    /**
     * Método que se ejecuta al iniciar la aplicación para cargar datos iniciales.
     *
     * @param args Argumentos de la línea de comandos.
     * @throws Exception en caso de error.
     */
    @Override
    public void run(String... args) throws Exception {
        empleadoRepository.save(new Empleado(null, "Juan Pérez", "Desarrollador", 50000, LocalDate.of(2020, 1, 1)));
        empleadoRepository.save(new Empleado(null, "Ana Gómez", "Analista", 40000, LocalDate.of(2019, 5, 15)));
        empleadoRepository.save(new Empleado(null, "Luis Ramírez", "Gerente", 70000, LocalDate.of(2018, 10, 30)));
    }
}
