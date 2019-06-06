package com.comment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScans;

@SpringBootApplication(scanBasePackages = "com.comment")
public class CoursecommentApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoursecommentApplication.class, args);
	}

}
