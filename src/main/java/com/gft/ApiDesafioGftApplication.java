package com.gft;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class ApiDesafioGftApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiDesafioGftApplication.class, args);
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		System.out.println(bCryptPasswordEncoder.encode("Gft@1234"));
	}

}
