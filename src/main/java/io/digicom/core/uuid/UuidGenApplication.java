package io.digicom.core.uuid;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
//@EnableAsync
public class UuidGenApplication {

	public static void main(String[] args) {
		SpringApplication.run(UuidGenApplication.class, args);
	}
}
