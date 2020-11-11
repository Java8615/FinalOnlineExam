package com.lti.OnlineExam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication

@ComponentScan({"com.lti"})
@EntityScan(basePackages = "com.lti")
public class OnlineExamApplication {

	public static void main(String[] args) {
		System.out.println("W O R K I N G . . .");
		SpringApplication.run(OnlineExamApplication.class, args);
	}

}
