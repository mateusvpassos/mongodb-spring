package br.com.mateus.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@ComponentScan(basePackages = "br.com.mateus.study.*")
@OpenAPIDefinition(info = @Info(title = "Mongo DB Spring", version = "1.0", description = "Spring Study"))
public class StudyApplication {

    public static void main(final String[] args) {
        SpringApplication.run(StudyApplication.class, args);
    }

}
