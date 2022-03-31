package dev.medi.meditime;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// @ComponentScan({"com.delivery.request"})
// @EntityScan("com.delivery.domain")
// @EnableJpaRepositories("com.delivery.repository")
@SpringBootApplication
public class MeditimeApplication {

	public static void main(String[] args) {
		SpringApplication.run(MeditimeApplication.class, args);
	}

	@Configuration
	public class WebMvcConfig implements WebMvcConfigurer {
		private final long MAX_AGE_SECS = 3600;

		@Override
		public void addCorsMappings(CorsRegistry registry) {
			registry.addMapping("/**")
				.allowedOrigins("http://localhost:3000")
			// GET, POST, PATCH, DELETE, OPTIONS 메서드 허용
					.allowedMethods("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS")
					.allowedHeaders("*")
					// .allowCredentials(true)
					.maxAge(MAX_AGE_SECS);
		}
	}

}
