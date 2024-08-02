package com.nach.pruebatecnica.gil.test.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Configuración de Swagger para la documentación de la API.
 * <p>
 * Gilberto García Sánchez
 * gilgasan1@gmail.com
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    /**
     * Configura Swagger para escanear el paquete del controlador.
     *
     * @return Instancia de Docket configurada para Swagger.
     */
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.nach.pruebatecnica.gil.test.controller"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }

    /**
     * Proporciona información de la API.
     *
     * @return Información de la API.
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Empleado API")
                .description("API para gestionar empleados. Permite realizar operaciones CRUD sobre la entidad Empleado.")
                .version("1.0.0")
                .build();
    }
}
