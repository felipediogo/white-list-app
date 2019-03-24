package br.com.felipediogo.whitelistapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("br.com.felipediogo")
public class WhiteListAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(WhiteListAppApplication.class, args);
	}

}
