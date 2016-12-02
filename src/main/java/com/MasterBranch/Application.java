package com.MasterBranch;

import java.util.HashSet;
import java.util.Set;

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
			Enquiry enquiry = new Enquiry("Testi Kysely", false);
	        Set querySet = new HashSet<Query>(){{
	            add(new Query(enquiry, "Kysymys 1", 0));
	            add(new Query(enquiry, "Kysymys 2", 0));
	            add(new Query(enquiry, "Kysymys 3", 0));
	        }};
	        enquiry.setQueries(querySet);
	        
	        erepository.save(new HashSet<Enquiry>() {{
	            add(enquiry);
	        }});

		};
	}
}
