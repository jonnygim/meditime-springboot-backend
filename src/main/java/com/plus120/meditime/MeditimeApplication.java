package com.plus120.meditime;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@ConfigurationPropertiesScan
@SpringBootApplication
public class MeditimeApplication {

	public static void main(String[] args) {
		SpringApplication.run(MeditimeApplication.class, args);
	}

}
