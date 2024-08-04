package com.kitaplik.libraryService;

import com.kitaplik.libraryService.client.RetreiveMessageErrorDecoder;
import feign.Logger;
import feign.codec.ErrorDecoder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableFeignClients
public class LibraryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibraryServiceApplication.class, args);
	}

/*
	//feign client error handling

	@Bean
	public ErrorDecoder errorDecoder(){
		return new RetreiveMessageErrorDecoder();
	}

	@Bean
	Logger.Level feignLoggerLevel(){
		return Logger.Level.FULL;
	}*/

}
