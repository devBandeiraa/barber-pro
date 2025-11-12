package br.com.devBandeira.barber_pro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class BarberProApplication {

	public static void main(String[] args) {
		SpringApplication.run(BarberProApplication.class, args);
	}

}
