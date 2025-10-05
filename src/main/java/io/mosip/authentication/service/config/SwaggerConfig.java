package io.mosip.authentication.service.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;

import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.security.*;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.context.annotation.Configuration;

@Configuration

@OpenAPIDefinition(
        info = @io.swagger.v3.oas.annotations.info.Info(title = "MOSIP TEST", version = "v1"),
        servers = {


                @Server(url = "http://localhost:8090/", description = "Local Server"),

        }
)


public class SwaggerConfig {}
