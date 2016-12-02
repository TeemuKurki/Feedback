package com.MasterBranch;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.MasterBranch.model.Enquiry;
import com.MasterBranch.model.Query;
import com.MasterBranch.repository.EnquiryRepository;
import com.MasterBranch.repository.QueryRepository;


@SpringBootApplication
public class Application {
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(QueryRepository qrepository, EnquiryRepository erepository) {
		return (args) -> {
			// save students
			Enquiry e = new Enquiry("Testi Kysely", false);
			Query q = new Query(e,"Testi kysymys", 0); 
			Query q1 = new Query(e,"Ääkköset", 0); 
			
			erepository.save(e);
			qrepository.save(q);
			qrepository.save(q1);

		};
	}
}
