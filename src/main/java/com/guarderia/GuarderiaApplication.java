package com.guarderia;

import com.guarderia.auth.AuthService;
import com.guarderia.auth.RegisterRequest;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import static com.guarderia.user.Role.*;

@SpringBootApplication
public class GuarderiaApplication {

	public static void main(String[] args) {
		SpringApplication.run(GuarderiaApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(
			AuthService service
	) {
		return args -> {
//			var admin = RegisterRequest.builder()
//					.firstname("Admin")
//					.lastname("Admin")
//					.username("admin")
//					.password("pass")
//					.role(ADMIN)
//					.build();
//			System.out.println("Admin token: " + service.register(admin).getAccessToken());
//
//			var empleado = RegisterRequest.builder()
//					.firstname("empleado")
//					.lastname("empleado")
//					.username("empleado")
//					.password("pass")
//					.role(EMPLEADO)
//					.build();
//			System.out.println("Empleado token: " + service.register(empleado).getAccessToken());
//
//			var socio = RegisterRequest.builder()
//					.firstname("socio")
//					.lastname("socio")
//					.username("socio")
//					.password("pass")
//					.role(SOCIO)
//					.build();
//			System.out.println("Socio token: " + service.register(socio).getAccessToken());

		};
	}

}
