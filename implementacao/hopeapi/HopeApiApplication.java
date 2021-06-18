package br.com.fatec.ads.es.hopeapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class HopeApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(HopeApiApplication.class, args);
	}

	
}
