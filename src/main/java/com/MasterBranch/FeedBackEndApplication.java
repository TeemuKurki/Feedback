package com.MasterBranch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FeedBackEndApplication {
	
	private static final Logger log = LoggerFactory.getLogger(FeedBackEndApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(FeedBackEndApplication.class, args);
	}
}
