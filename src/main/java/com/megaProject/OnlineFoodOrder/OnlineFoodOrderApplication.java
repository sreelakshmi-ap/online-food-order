package com.megaProject.OnlineFoodOrder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication

@ComponentScan(basePackages = { "com.megaProject.OnlineFoodOrder.Controllers", "com.megaProject.OnlineFoodOrder.Helper", "com.megaProject.OnlineFoodOrder.models",
		"com.megaProject.OnlineFoodOrder.Repository", "com.megaProject.OnlineFoodOrder.Request","com.megaProject.OnlineFoodOrder.Response", "com.megaProject.OnlineFoodOrder.Security", "com.megaProject.OnlineFoodOrder.Services" ,
		"com.megaProject.OnlineFoodOrder.config","com.megaProject.OnlineFoodOrder.Jwt"})
@EnableSwagger2
public class OnlineFoodOrderApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlineFoodOrderApplication.class, args);
	}
	
	@Configuration
	@EnableWebMvc
	public class WebConfig implements WebMvcConfigurer {

	@Override
	public void addCorsMappings(CorsRegistry corsRegistry) {
	corsRegistry.addMapping("/**").allowedOrigins("http://localhost:4200").allowedMethods("*").maxAge(3600L)
	.allowedHeaders("*").exposedHeaders("Authorization");
	}
	}
}