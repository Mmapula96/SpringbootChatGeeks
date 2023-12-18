package SpringChatGeeks.SpringbootChatGeeks;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.Arrays;
import java.util.Collections;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
@EnableWebMvc
public class SpringbootChatGeeksApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootChatGeeksApplication.class, args);
	}

}
