package com.joabregil.Ejemplo1;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EjemploPractica1Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(EjemploPractica1Application.class, args);
	}

    @Override
    public void run(String... args) throws Exception {
        System.out.println("api funcionando");
    }
}
